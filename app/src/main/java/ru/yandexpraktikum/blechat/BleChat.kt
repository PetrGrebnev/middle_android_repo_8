package ru.yandexpraktikum.blechat

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.HiltAndroidApp

private const val CHANNEL_ID = "channel_id"

@HiltAndroidApp
class BleChat: Application() {

    override fun onCreate() {
        super.onCreate()
        setUpNotificationsChannel()
    }

    private fun setUpNotificationsChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = this.getString(R.string.channel_name)
            val desc = this.getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = desc
            }

            NotificationManagerCompat.from(this).createNotificationChannel(channel)
        }
    }
}