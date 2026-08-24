package com.xingheyuzhuan.shiguangschedule.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.xingheyuzhuan.shiguangschedule.data.db.main.CourseTableConfig
import com.xingheyuzhuan.shiguangschedule.data.db.main.CourseTableConfigDao
import com.xingheyuzhuan.shiguangschedule.data.db.main.CourseTableDao
import com.xingheyuzhuan.shiguangschedule.data.model.AppSettingsModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.isoDayNumber
import kotlinx.datetime.toLocalDateTime
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import kotlin.time.Clock

@Single
class AppSettingsRepository(
    @Named("AppSettings") private val dataStore: DataStore<Preferences>,
    private val courseTableDao: CourseTableDao,
    private val courseTableConfigDao: CourseTableConfigDao
) {
    private val DATE_FORMATTER = LocalDate.Format {
        year()
        char('-')
        monthNumber()
        char('-')
        day()
    }

    private val COURSE_CONFIG_TEMPLATE = CourseTableConfig(
        courseTableId = "",
        showWeekends = false,
        semesterStartDate = null,
        semesterTotalWeeks = 20,
        defaultClassDuration = 45,
        defaultBreakDuration = 10,
        firstDayOfWeek = DayOfWeek.MONDAY.isoDayNumber
    )

    fun getAppSettings(): Flow<AppSettingsModel> = dataStore.data.map { prefs ->
        val dbFirstTableId = courseTableDao.getFirstTableOnce()?.id ?: ""
        AppSettingsModel.fromPreferences(prefs, dbFirstTableId)
    }

    suspend fun getAppSettingsOnce(): AppSettingsModel {
        return getAppSettings().first()
    }

    suspend fun insertOrUpdateAppSettings(newSettings: AppSettingsModel) {
        dataStore.edit { prefs ->
            prefs[AppSettingsModel.KEY_CURRENT_COURSE_TABLE_ID] = newSettings.currentCourseTableId
            prefs[AppSettingsModel.KEY_REMINDER_ENABLED] = newSettings.reminderEnabled
            prefs[AppSettingsModel.KEY_REMIND_BEFORE_MINUTES] = newSettings.remindBeforeMinutes
            prefs[AppSettingsModel.KEY_SKIPPED_DATES] = newSettings.skippedDates
            prefs[AppSettingsModel.KEY_AUTO_MODE_ENABLED] = newSettings.autoModeEnabled
            prefs[AppSettingsModel.KEY_AUTO_CONTROL_MODE] = newSettings.autoControlMode.value
            prefs[AppSettingsModel.KEY_COMPAT_WEARABLE_SYNC] = newSettings.compatWearableSync
            prefs[AppSettingsModel.KEY_SHOW_NON_CURRENT_WEEK_COURSES] = newSettings.showNonCurrentWeekCourses
            prefs[AppSettingsModel.KEY_START_SCREEN] = newSettings.startScreen.value
            prefs[AppSettingsModel.KEY_THEME_MODE] = newSettings.themeMode.value
            prefs[AppSettingsModel.KEY_USE_DYNAMIC_COLOR] = newSettings.useDynamicColor
            prefs[AppSettingsModel.KEY_CUSTOM_LIGHT_PRIMARY] = newSettings.customLightPrimary
            prefs[AppSettingsModel.KEY_CUSTOM_DARK_PRIMARY] = newSettings.customDarkPrimary
            prefs[AppSettingsModel.KEY_DEVELOPER_MODE_ENABLED] = newSettings.developerModeEnabled
            prefs[AppSettingsModel.KEY_HAS_VISITED_TIME_SLOT_SETTINGS] = newSettings.hasVisitedTimeSlotSettings
        }
    }

    suspend fun markTimeSlotSettingsVisited() {
        dataStore.edit { prefs ->
            prefs[AppSettingsModel.KEY_HAS_VISITED_TIME_SLOT_SETTINGS] = true
        }
    }

    suspend fun getCourseConfigOnce(tableId: String): CourseTableConfig? {
        return courseTableConfigDao.getConfigOnce(tableId)
    }

    fun getCourseTableConfigFlow(courseTableId: String): Flow<CourseTableConfig?> {
        return courseTableConfigDao.getConfigById(courseTableId)
    }

    suspend fun insertOrUpdateCourseConfig(newConfig: CourseTableConfig) {
        val constrainedConfig = when {
            newConfig.firstDayOfWeek == DayOfWeek.SUNDAY.isoDayNumber -> {
                newConfig.copy(showWeekends = true)
            }
            !newConfig.showWeekends -> {
                newConfig.copy(firstDayOfWeek = DayOfWeek.MONDAY.isoDayNumber)
            }
            else -> newConfig
        }
        courseTableConfigDao.insertOrUpdate(constrainedConfig)
    }

    fun getWeekIndexAtDate(
        targetDate: LocalDate,
        startDateStr: String?,
        firstDayOfWeekInt: Int
    ): Int? {
        if (startDateStr.isNullOrEmpty()) return null
        return try {
            val targetFirstDayOfWeek = DayOfWeek(firstDayOfWeekInt)
            val parsedStartDate = LocalDate.parse(startDateStr, DATE_FORMATTER)

            val alignedStartDate = getPreviousOrSameDayOfWeek(parsedStartDate, targetFirstDayOfWeek)
            val alignedTargetDate = getPreviousOrSameDayOfWeek(targetDate, targetFirstDayOfWeek)

            val diffDays = alignedTargetDate.toEpochDays() - alignedStartDate.toEpochDays()
            val diffWeeks = (diffDays / 7).toInt()
            diffWeeks + 1
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun calculateCurrentWeekFromDb(): Flow<Int?> = getAppSettings().flatMapLatest { appSettings ->
        val currentCourseId = appSettings.currentCourseTableId.ifEmpty {
            return@flatMapLatest flowOf(null)
        }
        courseTableConfigDao.getConfigById(currentCourseId).map { config ->
            if (config == null) return@map null
            val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
            val rawWeek = getWeekIndexAtDate(
                targetDate = today,
                startDateStr = config.semesterStartDate,
                firstDayOfWeekInt = config.firstDayOfWeek
            ) ?: return@map null
            if (rawWeek in 1..config.semesterTotalWeeks) rawWeek else null
        }
    }

    suspend fun setSemesterStartDateFromWeek(week: Int?) {
        val appSettings = getAppSettingsOnce()
        val currentCourseId = appSettings.currentCourseTableId.ifEmpty { return }

        val currentConfig = courseTableConfigDao.getConfigOnce(currentCourseId)
            ?: COURSE_CONFIG_TEMPLATE.copy(courseTableId = currentCourseId)

        val newStartDate = if (week != null) {
            calculateSemesterStartDate(week, currentConfig.firstDayOfWeek)
        } else {
            null
        }

        val updatedConfig = currentConfig.copy(semesterStartDate = newStartDate)
        courseTableConfigDao.insertOrUpdate(updatedConfig)
    }

    private fun calculateSemesterStartDate(week: Int, firstDayOfWeekInt: Int): String {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        val firstDayOfWeek = DayOfWeek(firstDayOfWeekInt)
        val startOfThisWeek = getPreviousOrSameDayOfWeek(today, firstDayOfWeek)
        val daysToSubtract = (week - 1) * 7
        val semesterStartDate = LocalDate.fromEpochDays(startOfThisWeek.toEpochDays() - daysToSubtract)
        return semesterStartDate.format(DATE_FORMATTER)
    }

    private fun getPreviousOrSameDayOfWeek(date: LocalDate, targetDayOfWeek: DayOfWeek): LocalDate {
        val currentDay = date.dayOfWeek.isoDayNumber
        val targetDay = targetDayOfWeek.isoDayNumber
        val daysToSubtract = if (currentDay >= targetDay) {
            currentDay - targetDay
        } else {
            7 - (targetDay - currentDay)
        }
        return LocalDate.fromEpochDays(date.toEpochDays() - daysToSubtract)
    }
}