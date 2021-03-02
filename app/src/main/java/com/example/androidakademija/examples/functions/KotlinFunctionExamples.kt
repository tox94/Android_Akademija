package com.example.androidakademija.examples.functions

import kotlin.random.Random

object KotlinFunctionExamples {

    fun getRandomNumber(): Int {
        return Random.nextInt(100)
    }

//    fun person(name: String, age: Int = 42, isRightHanded: Boolean = false) =
//        name + ", " +  age + ", " + isRightHanded
//
//    fun usePerson() = listOf(
//        person("John"),
//        person("Peter", age = 1),
//        person("Emily", isRightHanded = true),
//        person(name = "Jane", age = 2, isRightHanded = true)
//    )
}