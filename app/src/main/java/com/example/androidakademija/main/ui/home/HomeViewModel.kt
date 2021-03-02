package com.example.androidakademija.main.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidakademija.examples.functions.KotlinFunctionExamples.getRandomNumber

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment" + getRandomNumber()
    }
    val text: LiveData<String> = _text
}