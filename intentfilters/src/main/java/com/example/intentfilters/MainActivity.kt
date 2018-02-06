package com.example.intentfilters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onOkay(view: View?)
    {
        dial()
    }
    private fun dial() {
        startActivity(
                Intent(Intent.ACTION_DIAL)
        )
    }
    private fun call() {
        val int = Intent(Intent.ACTION_CALL)
        int.data = Uri.parse("tel://9819481417")
        startActivity(
                int
        )
    }
    private fun implicit() {
        val int = Intent()
        int.action = "com.codekul.action.common"
        int.addCategory("com.codekul.category.sports")
        int.data = Uri.parse("http://codekul.kul")
        startActivity(int)
    }
    private fun main() {
        val int = Intent(Intent.ACTION_MAIN)
        int.addCategory(Intent.CATEGORY_LAUNCHER)
        startActivity(int)
    }
    private fun explicit() {
        startActivity(
                Intent(
                        this@MainActivity,
                        SportsActivity::class.java
                )
        )
    }
}
