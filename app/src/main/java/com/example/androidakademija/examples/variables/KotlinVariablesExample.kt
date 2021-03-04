package com.example.androidakademija.examples.variables

import android.annotation.SuppressLint

var x = 10
var y: Int = 20
var n = 0.4

@SuppressLint("DefaultLocale")
fun main() {

    x++
    y -= 3

    // examples of default values used in strings
    val stringX = "x = $x"
    val stringY = "y = $y"

    val s = "test string"

    println(s)
    println(s.toUpperCase())
    for (character in s) {
        println(character)
    }
    println(s)

    println(stringX)
    println(stringY)

    val k = x + n

    println("k = $k")

    // examples of a default function used in a string
    println("x + y = ${x+y}")

    val z = 5
    // this can not compile because z is a val, which means its value is final
    z += 5
}