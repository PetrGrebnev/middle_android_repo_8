package ru.yandexpraktikum.blechat.presentation.notifications

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.yandexpraktikum.blechat.R
import javax.inject.Inject

private const val CHANNEL_ID = "channel_id"
private const val NOTIFICATION_ID = 1234

class NotificationsHelperImpl
@Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManagerCompat
) : NotificationsHelper {

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun notifyOnMessageReceived(title: String, message: String) {

        val notification = NotificationCompat.Builder(context, CHANNEL_ID )
            .setSmallIcon(R.drawable.bluetooth_ic)
            .setContentTitle(title)
            .setContentText(message)
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}