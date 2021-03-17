package com.example.androidakademija.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidakademija.R
import com.example.androidakademija.main.model.Person
import com.example.androidakademija.main.viewmodels.MainActivityViewModel

class AddPersonFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add, container, false)
        val button = root.findViewById<Button>(R.id.button_add)
        val firstName = root.findViewById<EditText>(R.id.editTextFirstName)
        val lastName = root.findViewById<EditText>(R.id.editTextLastName)
        val age = root.findViewById<EditText>(R.id.editTextAge)
        val oib = root.findViewById<EditText>(R.id.editTextOib)
        button.setOnClickListener {
            val person = Person(
                firstName.text.toString(), lastName.text.toString(),
                age.text.toString().toInt(), oib.text.toString().toLong()
            )
            viewModel.addPerson(person)
            firstName.text.clear()
            lastName.text.clear()
            age.text.clear()
            oib.text.clear()
        }
        return root
    }
}