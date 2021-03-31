package com.example.androidakademija.contact

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidakademija.R
import com.example.androidakademija.databinding.ActivityContactBinding
import com.example.androidakademija.main.model.Person

const val EXTRA_PERSON = "EXTRA_PERSON"

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val contact = intent.getSerializableExtra(EXTRA_PERSON) as Person

        binding.contactImage.load(contact.imageUrl) {
            placeholder(R.drawable.ic_baseline_person_add_24)
            transformations(CircleCropTransformation())
        }

        binding.toolbarLayout.title = "${contact.firstName} ${contact.lastName}"
        binding.itemDetails.text = contact.getDetails()
    }

    private fun Person.getDetails(): String {
        return "${getString(this.gender.abbreviation)}\n${this.age}\n${this.oib}"
    }
}