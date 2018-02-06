package com.example.broadcastrecivers

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View

class MainActivity : AppCompatActivity() {

    private val br = MyReceiver()
    private val fltr= IntentFilter()
    private var lbrMgr : LocalBroadcastManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        lbrMgr = LocalBroadcastManager
                .getInstance(this@MainActivity)

        fltr.addAction("com.codkul.my.action")
        fltr.addAction("android.intent.action.ACTION_POWER_CONNECTED")
        fltr.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
    }

    fun onOkay (vw: View?){
       // sendBroadcast(Intent("com.codkul.my.action"))
    }
    override fun onStart() {
        super.onStart()
        //registerReceiver(br,fltr)
        lbrMgr?.registerReceiver(br, fltr)
    }
    override fun onStop() {
       // unregisterReceiver(br)
        lbrMgr?.unregisterReceiver(br)
        super.onStop()
    }
}
