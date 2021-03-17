package com.example.androidakademija.main.model

import java.io.Serializable

class Person constructor(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val oib: Long
) : Serializable