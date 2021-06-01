package com.example.t4fris.Notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.content.Context
import android.app.Notification
import androidx.annotation.RequiresApi
import com.example.t4fris.R

class Notificatons(private val notificationManager: NotificationManager ) {

    fun makeNotificationChannel (id: String, name: String){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(id,name, importance)

            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100,200,300,400,500,400,300,200,400)
            notificationManager.createNotificationChannel(channel)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendNotif(context: Context, titleText: String, contentText: String){

        val notifId = 200
        val channelId = context.getString(R.string.notificationChannel)

        val notif = Notification.Builder(context, channelId)
            .setContentTitle(titleText)
            .setContentText(contentText)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setChannelId(channelId)
            .build()

        notificationManager.notify(notifId, notif)
    }
}