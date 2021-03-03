package com.example.androidakademija.examples.variables

var x = 10
var y:Int=20
var n = 0.4

fun main() {

    x++
    y-=3

    val stringX = "x = " + x
    val stringY = "y = " + y

    println(stringX)
    println(stringY)

    val k = x + n

    println("k = $k")

//    println("x + y = ${x+y}")

//    val z = 5
//    z += 5
}