package com.example.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.SharedPreferences
import android.util.Log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onRead(view: View){
        val shprf = getSharedPreferences("my prefs",MODE_PRIVATE)
        val nm= shprf.getString("nm","none")
        val age=shprf.getInt("age",-2)
        val isOkay=shprf.getBoolean("isOkay",false)
        val  strength =shprf.getFloat("strength", -9f)

        Log.i("@codekul","""name-$nm Age-$age isOkay - $isOkay Strength - $strength """)

    }


    fun onWrite(view: View){

        val shPrf = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val edtr = shPrf.edit()
        edtr.putString("nm", "android")
        edtr.putInt("age",15)
        edtr.putBoolean("isOkay", true)
        edtr.putFloat("strength", 45.6f)
        edtr.apply()
    }
}
