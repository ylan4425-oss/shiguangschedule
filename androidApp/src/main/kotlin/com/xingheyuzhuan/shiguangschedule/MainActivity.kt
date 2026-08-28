package com.xingheyuzhuan.shiguangschedule

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.xingheyuzhuan.shiguangschedule.widget.WidgetIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val launchTarget = parseWidgetTarget(intent)
        setContent {
            App(launchTarget = launchTarget)
        }
    }

    /**
     * 解析小组件点击带入的跳转目标。
     * 配合 NEW_TASK | CLEAR_TASK 的启动方式，每次小组件点击都会走 onCreate，
     * 因此无需额外处理 onNewIntent。
     */
    private fun parseWidgetTarget(intent: Intent?): WidgetLaunchTarget? {
        return when (intent?.getStringExtra(WidgetIntent.EXTRA_WIDGET_TARGET)) {
            WidgetIntent.TARGET_TODAY -> WidgetLaunchTarget.TODAY
            WidgetIntent.TARGET_WEEK -> WidgetLaunchTarget.WEEK
            else -> null
        }
    }
}