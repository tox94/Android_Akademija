package com.example.androidakademija.examples.singleton

object KotlinSingleton {
    var counter = 0

    fun increment() {
        counter++
    }
}

fun main() {
    val singleton = KotlinSingleton
    println(singleton.counter)
    singleton.increment()
    singleton.increment()
    singleton.increment()
    println(singleton.counter)
}