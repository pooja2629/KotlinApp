package com.example.services

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val intent = Intent(this@MainActivity,MyService::class.java)
        btnStart.setOnClickListener{
          //  startService(intent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            }else {
                startService(intent)
            }
        }
        btnStop.setOnClickListener {
            stopService(intent)
        }
    }
}
