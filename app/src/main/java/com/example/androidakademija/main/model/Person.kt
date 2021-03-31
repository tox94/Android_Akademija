package com.example.androidakademija.main.model

import com.example.androidakademija.R
import java.io.Serializable

class Person(
    val imageUrl: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val oib: Long,
    val gender: Gender
) : Serializable

enum class Gender(val abbreviation: Int) {
    MALE(R.string.gender_male_short), FEMALE(R.string.gender_female_short), OTHER(R.string.gender_other_short)
}