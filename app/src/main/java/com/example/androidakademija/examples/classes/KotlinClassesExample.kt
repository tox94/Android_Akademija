package com.example.androidakademija.examples.classes

import java.io.Serializable

open class Person constructor(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val oib: Long
) : Serializable

class University(
    val id: Int,
    val name: String
) : Serializable

class Student(
    firstName: String,
    lastName: String,
    age: Int,
    oib: Long,
    private val jmbag: Int,
    val university: University
) : Person(firstName, lastName, age, oib) {
    fun getDetails() = "$firstName $lastName, $jmbag"
}

fun main() {
    val fer = University(123, "FER")
    val studentA = Student("Pero", "Peric", 21, 123456789123, 1655238435, fer)
    val studentB = Student("Ivana", "Horvat", 22, 987654987654, 1564654335, fer)
    println(studentA.getDetails())
    println(studentB.getDetails())
}
