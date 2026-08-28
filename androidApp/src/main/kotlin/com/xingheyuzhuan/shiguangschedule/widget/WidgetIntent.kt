package com.xingheyuzhuan.shiguangschedule.widget

/**
 * 桌面小组件点击跳转相关的 Intent 约定。
 *
 * 各原生 Renderer 在构造根布局点击 Intent 时，通过 [EXTRA_WIDGET_TARGET]
 * 告知 App 应当跳转到哪个页面；[MainActivity] 读取后映射为 [com.xingheyuzhuan.shiguangschedule.WidgetLaunchTarget]。
 */
object WidgetIntent {
    /** 小组件点击携带的目标标记 extra key */
    const val EXTRA_WIDGET_TARGET = "com.xingheyuzhuan.shiguangschedule.extra.WIDGET_TARGET"

    /** 跳转到「今日课表」（Tiny / Compact / DoubleDays 等以今日为主的组件使用） */
    const val TARGET_TODAY = "today"

    /** 跳转到「周课表·当前周」（ListVertical 等以整周为主的组件使用） */
    const val TARGET_WEEK = "week"
}
