package com.example.androidakademija.examples.nullability

fun main() {
    val s1 = "abc"
    var s2: String? = null

    s2?.let {
        println("Print = $it")
    }

    if (s1.length < 10) {
        s2 = "def"
    }

    s2?.let {
        println("Print = $it")
    }

//    if (s1.length < 10) {
//        s2 = null
//    }
//
//    val length = s2?.length ?: -1
//    println("Length = $length")

//    s2?.let {
//        println("Length = $it")
//    }
//    println("Length = ${s2!!.length }}")
}