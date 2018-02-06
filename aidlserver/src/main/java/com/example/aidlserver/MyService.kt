package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val impl = MyImpl()

    override fun onBind(intent: Intent): IBinder? = impl
    class MyImpl  : ICalc.Stub() {

        override fun calc(num1: Int, num2: Int): Int {
            Log.i("@codekul", """ num1 $num1 num2 $num2 """)
            return num1 + num2

        }

    }
}
