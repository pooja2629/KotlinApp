package com.example.aidlclient


import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.name
import android.content.pm.ResolveInfo
import android.content.pm.PackageManager


class MainActivity : AppCompatActivity() {

    var impl : ICalc? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBind.setOnClickListener {
            val srCon = object : ServiceConnection {
                override fun onServiceDisconnected(p0: ComponentName?) {
                    Toast.makeText(this@MainActivity, "Service DisConnected", Toast.LENGTH_SHORT).show()
                    impl = null
                }
                override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
                    Toast.makeText(this@MainActivity, "Service Connected", Toast.LENGTH_SHORT).show()
                    impl  = ICalc.Stub.asInterface(binder)
                }
            }
            val intent = Intent("com.codekul.my.action")
            bindService(createExplicitFromImplicitIntent(intent), srCon, BIND_AUTO_CREATE)
        }
        btnCalc.setOnClickListener {
            txtInf.text = impl?.calc(123, 568).toString()
        }
    }
    private fun createExplicitFromImplicitIntent(implicitIntent: Intent): Intent? {
        // Retrieve all services that can match the given intent
        val pm = packageManager
        val resolveInfo = pm.queryIntentServices(implicitIntent, 0)
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo!!.size != 1) {
            return null
        }
        // Get component info and create ComponentName
        val serviceInfo = resolveInfo!!.get(0)
        val packageName = serviceInfo.serviceInfo.packageName
        val className = serviceInfo.serviceInfo.name
        val component = ComponentName(packageName, className)
        // Create a new intent. Use the old one for extras and such reuse
        val explicitIntent = Intent(implicitIntent)
        // Set the component to be explicit
        explicitIntent.component = component
        return explicitIntent
    }
}

