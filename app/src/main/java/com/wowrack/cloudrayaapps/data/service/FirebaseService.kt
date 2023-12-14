package com.wowrack.cloudrayaapps.data.service

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.Constants.MessageNotificationKeys.TAG
import com.squareup.picasso.Picasso
import com.wowrack.cloudrayaapps.R

class FirebaseService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
    }

    @SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "Dikirim dari: ${remoteMessage.from}")

        if (remoteMessage.notification != null) {
            if (remoteMessage.data.isNotEmpty()) {
                Log.d(TAG, "Message data payload: ${remoteMessage.data}")
            }

        }

        Log.d(TAG, "From: ${remoteMessage.from}")

        remoteMessage.notification?.let {
            showNotification(it.title.toString(), it.body.toString(), it.imageUrl.toString() )
            Log.d(TAG, "Message Notification Title: ${it.title}")
            Log.d(TAG, "Message Notification Body: ${it.body}")
            Log.d(TAG, "Message Notification Image: ${it.imageUrl.toString()}")
        }
    }

    private fun showNotification(title: String, message: String, imageUrl: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.cloudraya_login_logo)
            .setLargeIcon(Picasso.get().load(imageUrl).get())
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(Picasso.get().load(imageUrl).get()).bigLargeIcon(Picasso.get().load(imageUrl).get()))
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        builder.setChannelId(CHANNEL_ID)
        notificationManager.createNotificationChannel(channel)
        val notification = builder.build()
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "channel_01"
        private const val CHANNEL_NAME = "CloudRaya Notification"
    }
}