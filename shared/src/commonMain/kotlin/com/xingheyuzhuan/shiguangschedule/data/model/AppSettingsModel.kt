package com.xingheyuzhuan.shiguangschedule.data.model

import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import org.jetbrains.compose.resources.StringResource
import shiguangschedule.shared.generated.resources.*
import com.xingheyuzhuan.shiguangschedule.ui.theme.DefaultThemeColor

enum class AutoControlMode(val value: String) {
    DND("DND"),
    SILENT("SILENT");

    companion object {
        fun fromString(value: String?): AutoControlMode {
            return entries.find { it.value == value } ?: DND
        }
    }
}

enum class StartScreen(val value: String, val labelRes: StringResource) {
    COURSE_SCHEDULE("COURSE_SCHEDULE", Res.string.nav_course_schedule),
    TODAY_SCHEDULE("TODAY_SCHEDULE", Res.string.nav_today_schedule);

    companion object {
        fun fromString(value: String?): StartScreen {
            return entries.find { it.value == value } ?: COURSE_SCHEDULE
        }
    }
}

enum class AppThemeMode(val value: String, val labelRes: StringResource) {
    FOLLOW_SYSTEM("FOLLOW_SYSTEM", Res.string.theme_follow_system),
    LIGHT("LIGHT", Res.string.theme_light),
    DARK("DARK", Res.string.theme_dark);

    companion object {
        fun fromString(value: String?): AppThemeMode? {
            return entries.find { it.value == value }
        }
    }
}

data class AppSettingsModel(
    val currentCourseTableId: String = "",
    val reminderEnabled: Boolean = false,
    val remindBeforeMinutes: Int = 15,
    val skippedDates: Set<String> = emptySet(),
    val autoModeEnabled: Boolean = false,
    val autoControlMode: AutoControlMode = AutoControlMode.DND,
    val compatWearableSync: Boolean = false,
    val showNonCurrentWeekCourses: Boolean = false,
    val startScreen: StartScreen = StartScreen.COURSE_SCHEDULE,
    val themeMode: AppThemeMode = AppThemeMode.FOLLOW_SYSTEM,
    val useDynamicColor: Boolean = true,
    val customLightPrimary: Long = DefaultThemeColor.toArgb().toLong(),
    val customDarkPrimary: Long = DefaultThemeColor.toArgb().toLong(),
    val developerModeEnabled: Boolean = false,
    val hasVisitedTimeSlotSettings: Boolean = false,
) {
    companion object {
        val KEY_CURRENT_COURSE_TABLE_ID = stringPreferencesKey("current_course_table_id")
        val KEY_REMINDER_ENABLED = booleanPreferencesKey("reminder_enabled")
        val KEY_REMIND_BEFORE_MINUTES = intPreferencesKey("remind_before_minutes")
        val KEY_SKIPPED_DATES = stringSetPreferencesKey("skipped_dates")
        val KEY_AUTO_MODE_ENABLED = booleanPreferencesKey("auto_mode_enabled")
        val KEY_AUTO_CONTROL_MODE = stringPreferencesKey("auto_control_mode")
        val KEY_COMPAT_WEARABLE_SYNC = booleanPreferencesKey("compat_wearable_sync")
        val KEY_SHOW_NON_CURRENT_WEEK_COURSES = booleanPreferencesKey("show_non_current_week_courses")
        val KEY_START_SCREEN = stringPreferencesKey("start_screen")
        val KEY_THEME_MODE = stringPreferencesKey("theme_mode")
        val KEY_USE_DYNAMIC_COLOR = booleanPreferencesKey("use_dynamic_color")
        val KEY_CUSTOM_LIGHT_PRIMARY = longPreferencesKey("custom_light_primary")
        val KEY_CUSTOM_DARK_PRIMARY = longPreferencesKey("custom_dark_primary")
        val KEY_DEVELOPER_MODE_ENABLED = booleanPreferencesKey("developer_mode_enabled")
        val KEY_HAS_VISITED_TIME_SLOT_SETTINGS = booleanPreferencesKey("has_visited_time_slot_settings")

        fun fromPreferences(prefs: Preferences, fallbackTableId: String): AppSettingsModel {
            val d = AppSettingsModel()
            return AppSettingsModel(
                currentCourseTableId = prefs[KEY_CURRENT_COURSE_TABLE_ID] ?: fallbackTableId.ifEmpty { d.currentCourseTableId },
                reminderEnabled = prefs[KEY_REMINDER_ENABLED] ?: d.reminderEnabled,
                remindBeforeMinutes = prefs[KEY_REMIND_BEFORE_MINUTES] ?: d.remindBeforeMinutes,
                skippedDates = prefs[KEY_SKIPPED_DATES] ?: d.skippedDates,
                autoModeEnabled = prefs[KEY_AUTO_MODE_ENABLED] ?: d.autoModeEnabled,
                autoControlMode = AutoControlMode.fromString(prefs[KEY_AUTO_CONTROL_MODE]),
                compatWearableSync = prefs[KEY_COMPAT_WEARABLE_SYNC] ?: d.compatWearableSync,
                showNonCurrentWeekCourses = prefs[KEY_SHOW_NON_CURRENT_WEEK_COURSES] ?: d.showNonCurrentWeekCourses,
                startScreen = prefs[KEY_START_SCREEN]?.let { StartScreen.fromString(it) } ?: d.startScreen,
                themeMode = prefs[KEY_THEME_MODE]?.let { AppThemeMode.fromString(it) } ?: d.themeMode,
                useDynamicColor = prefs[KEY_USE_DYNAMIC_COLOR] ?: d.useDynamicColor,
                customLightPrimary = prefs[KEY_CUSTOM_LIGHT_PRIMARY] ?: d.customLightPrimary,
                customDarkPrimary = prefs[KEY_CUSTOM_DARK_PRIMARY] ?: d.customDarkPrimary,
                developerModeEnabled = prefs[KEY_DEVELOPER_MODE_ENABLED] ?: d.developerModeEnabled,
                hasVisitedTimeSlotSettings = prefs[KEY_HAS_VISITED_TIME_SLOT_SETTINGS] ?: d.hasVisitedTimeSlotSettings,
            )
        }
    }
}