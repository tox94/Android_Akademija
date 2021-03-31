package com.example.androidakademija.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidakademija.main.model.Gender
import com.example.androidakademija.main.model.Person

class MainActivityViewModel: ViewModel() {

    val peopleList = MutableLiveData<ArrayList<Person>>()

    init {
        peopleList.value = arrayListOf(
            Person(
                "https://api.sofascore.com/api/v1/team/7135/image",
                "Pero",
                "Peric",
                22,
                123123123123,
                Gender.MALE
            ),
            Person(
                "https://upload.wikimedia.org/wikipedia/commons/d/d9/Lionel_Messi_20180626_%28cropped%29.jpg",
                "Ivana",
                "Kovacevic",
                21,
                456456456456,
                Gender.FEMALE
            ),
            Person(
                "https://www.sofascore.com/static/images/apple-icon-180x180.png",
                "Josip",
                "Horvat",
                19,
                789789789789,
                Gender.MALE
            ),
            Person(
                "https://www.sofascore.com/static/images/apple-icon-180x180.png",
                "Ivona",
                "Kovac",
                20,
                321321321321,
                Gender.FEMALE
            )
        )
    }

    fun addPerson(person: Person) {
        peopleList.value?.add(person)
    }
}