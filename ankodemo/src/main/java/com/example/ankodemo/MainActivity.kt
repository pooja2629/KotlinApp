package com.example.ankodemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            button("Alert") {
                onClick {
                    alert {
                        title = "Title"
                        message = "Message"
                        yesButton {
                            toast("""system is working""")
                        }
                        noButton {
                            toast("""system is not working""")

                        }
                    }.show()
                }
            }
            button("Date Picker") {
                onClick {
                    DatePickerDialog(
                            this@MainActivity,
                            DatePickerDialog.OnDateSetListener { _, yr, mnth, dt ->
                                toast(""" $dt - ${mnth + 1}  $yr """)
                            },
                            2016,
                            0,
                            16
                    ).show()
                }
            }
            button("Time Picker") {
                onClick {
                    TimePickerDialog(
                            this@MainActivity, { _, hh, mm ->
                        toast(""" $hh : $mm """)
                    },
                            1,
                            12,
                            false
                    ).show()
                }
            }
            button("Custom"){
                onClick {
                    alert {
//                        customView {
//                            verticalLayout {
//                               val nm = editText()
//
//                                button("GO"){
//                                    toast("""Go Clicked ${nm.text}""")
//                                }
//                            }
//                        }
                        customView = View
                                .inflate(this@MainActivity,R.layout.custom,null)
                    }.show()
                }
            }
            button("Progress"){
                onClick {

                       // indeterminateProgressDialog("Loading").show() // - for Spinner
                        progressDialog("Please wait a minute.",
                                "Downloading…").show()
                }
            }
        }
    }
}


