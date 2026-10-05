/*
 * 文件已被修改（Modified file）— 依据 Apache License 2.0 第 4(b) 条标注。
 * 原始项目：时光课程表（Copyright 2025 XingHeYuZhuan，Apache License 2.0）。
 * 本文件在原项目基础上由维护者修改，具体修改见仓库根目录 NOTICE 文件。
 * 原始许可证与版权声明见仓库根目录 LICENSE 文件，本文件其余部分仍受原许可证约束。
 */
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