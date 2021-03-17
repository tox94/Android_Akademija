package com.example.androidakademija.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidakademija.main.model.Person

class MainActivityViewModel: ViewModel() {

    val peopleList = MutableLiveData<ArrayList<Person>>()

    init {
        peopleList.value = arrayListOf(
            Person("Pero", "Peric", 22, 123123123123),
            Person("Ivana", "Kovacevic", 21, 456456456456),
            Person("Josip", "Horvat", 19, 789789789789),
            Person("Ivona", "Kovac", 20, 321321321321)
        )
    }

    fun addPerson(person: Person) {
        peopleList.value?.add(person)
    }
}