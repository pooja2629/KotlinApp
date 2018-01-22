package com.example.statusbarnotification

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun plsNtfy(view: View?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) chnl()
        else nrml()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @TargetApi(Build.VERSION_CODES.O)
    fun chnl() {
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = "my_channel_01"
        val name = "My Own Settings"
        val description = "description"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)
        mChannel.description = description
        mChannel.enableLights(true)
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        mNotificationManager.createNotificationChannel(mChannel)
        val pndInt = PendingIntent.getActivity(
                this@MainActivity,
                4568,
                Intent(
                        this@MainActivity,
                        NtfyActivity::class.java
                ),
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        mNotificationManager.notify(
                1234,
                NotificationCompat.Builder(this@MainActivity, id)
                        .setContentTitle("Title")
                        .setContentText("Content Text")
                        .setContentInfo("Content Info")
                        .setContentIntent(pndInt)
                        .setSmallIcon(R.mipmap.ic_launcher_round).build()
        )
    }
    fun nrml() {
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        val pndInt = PendingIntent.getActivity(
                this@MainActivity,
                4568,
                Intent(
                        this@MainActivity,
                        NtfyActivity::class.java
                ),
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        mgr.notify(
                1234,
                NotificationCompat.Builder(this@MainActivity)
                        .setContentTitle("Title")
                        .setContentText("Content Text")
                        .setContentInfo("Content Info")
                        .setContentIntent(pndInt)
                        .setSmallIcon(R.mipmap.ic_launcher_round).build()
        )
}
}
