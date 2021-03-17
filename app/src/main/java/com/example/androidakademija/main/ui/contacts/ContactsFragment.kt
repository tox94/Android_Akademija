package com.example.androidakademija.main.ui.contacts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.androidakademija.R
import com.example.androidakademija.main.model.Person
import com.example.androidakademija.main.viewmodels.MainActivityViewModel

class ContactsFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)
        val linearLayout = root.findViewById<LinearLayout>(R.id.contact_container)
        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            linearLayout.removeAllViews()
            for (person in it) {
                val row = inflater.inflate(R.layout.contact_row, linearLayout, false)
                val textView = row.findViewById<TextView>(R.id.contact_text)
                textView.text = person.getDetails()
                linearLayout.addView(row)
            }
        })
        return root
    }

    fun Person.getDetails() = "$firstName $lastName, $age, $oib"
}