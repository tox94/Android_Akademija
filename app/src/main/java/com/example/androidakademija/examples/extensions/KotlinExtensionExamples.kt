package com.example.androidakademija.examples.extensions

import com.example.androidakademija.examples.classes.Student
import com.example.androidakademija.examples.classes.University

/** Extension function for custom print */
fun Student.printDetails() {
    println("First name = ${this.firstName}")
    println("Last name = ${this.lastName}")
    println("Age = ${this.age}")
    println("University = ${this.university.name}")
}

/** Extension function for determining the length of last name
 * @param limit - highest allowed value */
fun Student.hasLongLastName(limit: Int): Boolean {
    return this.lastName.length > limit
}

/** Extension variable that tells whether the student is under aged */
val Student.isUnderAged: Boolean
    get() {
        return this.age < 18
    }

fun main() {
    val lastNameLimit = 8
    val fer = University(123, "FER")
    val studentA = Student("Ivana", "Horvat", 17, 987654987654, 1564654335, fer)
    val studentB = Student("Ivana", "Kovačević", 22, 987654987654, 1564654335, fer)
    if (studentA.hasLongLastName(lastNameLimit)) studentA.printDetails()
    if (studentB.hasLongLastName(lastNameLimit)) studentB.printDetails()
//    if (studentA.isUnderAged) studentA.printDetails()
//    if (studentB.isUnderAged) studentB.printDetails()
}
