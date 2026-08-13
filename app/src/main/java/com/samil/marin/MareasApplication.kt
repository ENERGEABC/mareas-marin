package com.samil.marin

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class MareasApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_USER_PRESENT)
        }

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                TideWidgetProvider.redrawAllWidgets(applicationContext)
            }
        }, filter)

        TideWidgetProvider.schedulePeriodicRedraw(applicationContext)
    }
}

