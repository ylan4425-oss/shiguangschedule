package com.xingheyuzhuan.shiguangschedule.widget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class WidgetRefreshReceiver : BroadcastReceiver() {
    companion object {
        const val ACTION_REFRESH = "com.xingheyuzhuan.shiguangschedule.WIDGET_REFRESH"
    }

    private val scope = MainScope()

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != ACTION_REFRESH) return
        Log.d("WidgetRefresh", "收到刷新请求")
        scope.launch {
            updateAllWidgets(context)
        }
    }
}
