package com.example.androidakademija.examples.functions

import com.example.androidakademija.examples.classes.Person
import com.example.androidakademija.examples.classes.University
import kotlin.random.Random

val fer = University(123, "FER")

fun getOneRandomNumber(): Int {
    return Random.nextInt(100)
}

class Student(
    firstName: String = "Ivan",
    lastName: String = "Kovačević",
    age: Int = 22,
    oib: Long,
    private val jmbag: Int,
    val university: University
) : Person(firstName, lastName, age, oib) {
    fun getDetails() = "$firstName $lastName, $age, $oib, $jmbag, ${university.name}"
}

fun getStudentList() = listOf(
    Student("Ivana", "Horvat", 22, 987654987654, 1564654335, fer),
    Student(firstName = "Pero", lastName = "Peric", oib = 123456789123, jmbag = 1655238435, university = fer),
    Student(firstName = "Pero", oib = 123456789123, jmbag = 1655238435, university = fer),
    Student(oib = 123456789123, jmbag = 1655238435, university = fer)
)

fun main() {
    println(getOneRandomNumber())
    val list = getStudentList()
    for (student in list) {
        println(student.getDetails())
    }
}