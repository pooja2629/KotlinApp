package com.example.internalstorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onRead(view: View) = extReadPub()
    fun onWrite(view: View) = extWritePub()
    private fun extReadPvt() {
        if (isWorking()) {
            val fl = File(
                    getExternalFilesDir("Docs"),
                    "my.txt"
            )
            val fis = FileInputStream(fl)
            txtinfo.text = fis.bufferedReader().use { it.readText() }
        }
    }
    private fun extWritePvt() {
        if (isWorking()) {
            val fl = File(
                    getExternalFilesDir("Docs"),
                    "my.txt"
            )
            Log.i("@codekul", """ File path - ${fl.absolutePath}""")
            val fos = FileOutputStream(fl)
            fos.write(editText.text.toString().toByteArray())
            fos.close()
        }
    }
    private fun extReadPub() {
        if (isWorking()) {
            val fl = File(
                    Environment.getExternalStoragePublicDirectory("Docs"),
                    "my.txt"
            )
            val fis = FileInputStream(fl)
            txtinfo.text = fis.bufferedReader().use { it.readText() }
        }
    }
    private fun extWritePub() {
        if (isWorking()) {
            Environment.getExternalStoragePublicDirectory("Docs").mkdir()
            val fl = File(
                    Environment.getExternalStoragePublicDirectory("Docs"),
                    "my.txt"
            )
            fl.createNewFile()
            Log.i("@codekul", """ File path - ${fl.absolutePath}""")
            val fos = FileOutputStream(fl)
            fos.write(editText.text.toString().toByteArray())
            fos.close()
        }
    }
    private fun isWorking() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    private fun internalRead() {
        val ofi = openFileInput("my.txt")
        txtinfo.text = ofi.bufferedReader().use { it.readText() }
        Log.i("@codekul", """getFilesDir - ${filesDir.absolutePath} """)
        Log.i("@codekul", """getDir - ${getDir("myPhotos", Context.MODE_PRIVATE).absolutePath} """)
        fileList().forEach {
            Log.i("@codekul", """ $it """)
        }
    }
    private fun internalWrite() {
        val ofo = openFileOutput("my.txt", Context.MODE_PRIVATE)
        ofo.write(editText.text.toString().toByteArray())
        ofo.close()
    }
}
