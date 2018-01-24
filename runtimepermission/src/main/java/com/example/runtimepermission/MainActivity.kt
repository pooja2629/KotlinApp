package com.example.runtimepermission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOkay.setOnClickListener { location() }
    }
    private fun location() {
        val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        )
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION)) {
                alert {
                    title = "Need Your Location"
                    message = "We wont steal your data, help us by enabling your location "
                    yesButton {
                        ActivityCompat.requestPermissions(
                                this@MainActivity,
                                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                1234)
                    }
                    noButton {
                        it.dismiss()
                    }
                }.show()
                return
            }
            return
        }
        lm.requestLocationUpdates("gps", 1000, 1f,
                object : LocationListener {
            override fun onLocationChanged(p0: Location?) {}
            override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {}
            override fun onProviderEnabled(p0: String?) {}
            override fun onProviderDisabled(p0: String?) {}
        })
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1234) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // allow
                location()
                toast("Allowed")
            } else {
                // deny
                toast("Denied")
                return
            }
        }
    }
}

