package com.example.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.support.annotation.RequiresApi

class MyService : Service() {


    private var mp:MediaPlayer? =null

//    override fun onCreate() {
//        super.onCreate()
//    }
    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

//    override fun onUnbind(intent: Intent?): Boolean {
//        return super.onUnbind(intent)
//    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            oreoNfn()
        }
        else
        {
            lwOreo()
        }

        mp=MediaPlayer.create(this,R.raw.my)
        mp?.start()
        return START_NOT_STICKY
    }
    @RequiresApi(Build.VERSION_CODES.O)

    private fun oreoNfn() {
        val notificationIntent = Intent(this, NotiActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val id = "chId"
        val name = "chNm"
        val description = "chDes"
        val importance = android.app.NotificationManager.IMPORTANCE_LOW
        val mChannel = NotificationChannel(id, name, importance)
        mChannel.description = description
        mChannel.enableLights(true)
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        val noti = Notification.Builder(this@MyService, "my-channel")
                .setContentTitle("Title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setTicker("Ticker")
                .build()
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.createNotificationChannel(mChannel)
        startForeground(1234, noti)
        mNotificationManager.notify(1234, noti)
    }

    private fun lwOreo()
    {
        val notificationIntent = Intent(this, NotiActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification = Notification.Builder(this@MyService)
                .setContentTitle("Title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setTicker("Ticker")
                .build()

        startForeground(1234, notification)
    }
    override fun onDestroy() {

        mp?.stop()
        mp?.release()
        super.onDestroy()
    }
}
