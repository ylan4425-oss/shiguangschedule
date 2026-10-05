/*
 * 新增文件（New file）— 基于 Apache License 2.0 贡献。
 * 原始项目：时光课程表（Copyright 2025 XingHeYuZhuan，Apache License 2.0）。
 * 本文件由维护者新增，整体分发仍须遵守 Apache License 2.0。
 * 详见仓库根目录 LICENSE 与 NOTICE 文件。
 */
package com.xingheyuzhuan.shiguangschedule

/**
 * 桌面小组件点击后带入 App 的启动目标。
 *
 * - [TODAY]：跳转到「今日课表」；
 * - [WEEK]：跳转到「周课表（当前周）」。
 *
 * 由 Android 端的 [androidx.appcompat.app.AppCompatActivity]（MainActivity）
 * 从小组件点击 Intent 的 extra 解析后，通过 [App] 的参数传入，
 * 仅用于决定本次启动的初始页面，不改变用户设置的默认启动页。
 */
enum class WidgetLaunchTarget {
    TODAY,
    WEEK
}
