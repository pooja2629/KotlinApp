package com.example.broadcastrecivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        //Toast.makeText(context, "event Received",Toast.LENGTH_SHORT).show()
        Toast.makeText(context, intent.action,Toast.LENGTH_SHORT).show()
    }
}
