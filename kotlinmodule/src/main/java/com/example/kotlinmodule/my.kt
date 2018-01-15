package com.example.kotlinmodule

/**
 * Created by Pooja on 15-01-2018.
 */

var nm: String = "android"
var mulLn =
        """
            ${12 * 56}
            programing language is $nm
            afsdg
            sgsfg
            sfgsfg
            sadg
            afag
        """.trimIndent()
var dt = 10
val enm = 456
var cnNl: String? = "java"
fun whatsNm(): String {
    dt = 80
    nm.toString()
    //nm = null not possible
    //enm = 96 // not possible
    cnNl = null
    cnNl?.toString()
    return "hello"
}
fun objects() {
    val fn = String()
}
fun loops() {
    println(""" value of nm is $nm """)
    val arr = arrayOf("Android", "Apple", "Windows", "Rim")
    arr.forEach {
        println(it)
    }
    for (i in arr) {
    }
    for (i in 1..100) {
        println(i)
    }
    when(nm) {
        "android" -> print("android")
        "java" -> print("hello")
    }
}