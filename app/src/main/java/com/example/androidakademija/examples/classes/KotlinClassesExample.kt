package com.example.androidakademija.examples.classes

import java.io.Serializable

open class Person constructor(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String,
    val oib: Long
) : Serializable

class University(
    val id: Int,
    val name: String
) : Serializable

class Student(
    firstName: String,
    lastName: String,
    dateOfBirth: String,
    oib: Long,
    private val jmbag: Int,
    val university: University
) : Person(firstName, lastName, dateOfBirth, oib) {
    fun getDetails() = "$firstName $lastName, $jmbag"
}

fun main() {
    val fer = University(123, "FER")
    val studentA = Student("Pero", "Peric", "12.04.1998.", 123456789123, 1655238435, fer)
    val studentB = Student("Ivana", "Horvat", "02.12.1999.", 987654987654, 1564654335, fer)
    println(studentA.getDetails())
    println(studentB.getDetails())
}
