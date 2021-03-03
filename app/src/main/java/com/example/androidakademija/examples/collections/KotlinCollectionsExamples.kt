package com.example.androidakademija.examples.collections

import com.example.androidakademija.examples.classes.Person

val peopleList = arrayListOf(
    Person("Pero", "Peric", 22, 123123123123),
    Person("Pero", "Peric", 21, 456456456456),
    Person("Pero", "Peric", 19, 789789789789),
    Person("Pero", "Peric", 17, 321321321321),
    Person("Pero", "Peric", 25, 654654654654),
)

val simpleMap = mapOf(3 to "c", 4 to "d", 5 to "e", 6 to "f", 1 to "a", 2 to "b")

fun Person.getDetails(): String {
    return "${this.firstName} ${this.lastName}, ${this.age}, ${this.oib}"
}

fun main() {
    for (person in peopleList) {
        println(person.getDetails())
    }

//    val sortedList = peopleList.sortedBy { it.age }
//    for (person in sortedList) {
//        println(person.getDetails())
//    }
//
//    val olderThanTwenty = peopleList.filter { it.age > 20 }
//    for (person in olderThanTwenty) {
//        println(person.getDetails())
//    }
//
//    val haveTwoInOib = peopleList.filter { it.oib.toString().contains("2") }
//    for (person in haveTwoInOib) {
//        println(person.getDetails())
//    }

//    for (entry in simpleMap) {
//        println("${entry.key} -> ${entry.value}")
//    }
//
//    val sorted = simpleMap.toSortedMap()
//    for (entry in sorted) {
//        println("${entry.key} -> ${entry.value}")
//    }
//
//    val largerThan3 = simpleMap.filter { it.key > 3 }
//    for (entry in largerThan3) {
//        println("${entry.key} -> ${entry.value}")
//    }
}