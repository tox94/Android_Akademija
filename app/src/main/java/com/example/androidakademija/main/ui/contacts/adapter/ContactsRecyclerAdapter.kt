package com.example.androidakademija.main.ui.contacts.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidakademija.R
import com.example.androidakademija.contact.ContactActivity
import com.example.androidakademija.contact.EXTRA_PERSON
import com.example.androidakademija.databinding.ContactItemViewBinding
import com.example.androidakademija.main.model.Gender
import com.example.androidakademija.main.model.Person

class ContactsRecyclerAdapter(
    private val context: Context,
    private val contactsList: ArrayList<Person>
) : RecyclerView.Adapter<ContactsRecyclerAdapter.ContactViewHolder>() {

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ContactItemViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_item_view, parent, false)
        return ContactViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val person = contactsList[position]
        when (person.gender) {
            Gender.MALE -> {
                holder.binding.root.backgroundTintList =
                    ColorStateList.valueOf(context.getColor(R.color.teal_700))
            }
            Gender.FEMALE -> {
                holder.binding.root.backgroundTintList =
                    ColorStateList.valueOf(context.getColor(R.color.purple_200))
            }
            Gender.OTHER -> {
                holder.binding.root.backgroundTintList =
                    ColorStateList.valueOf(context.getColor(R.color.teal_700))
            }
        }
        holder.binding.image.load(person.imageUrl) {
            placeholder(R.drawable.ic_baseline_person_add_24)
            transformations(CircleCropTransformation())
        }
        holder.binding.name.text = "${person.lastName}, ${person.firstName}"
        holder.binding.age.text = context.getString(R.string.years, person.age)
        holder.binding.gender.text = context.getString(person.gender.abbreviation)
        holder.binding.oib.text = person.oib.toString()
        holder.binding.root.setOnClickListener {
            val intent = Intent(context, ContactActivity::class.java).apply {
                putExtra(EXTRA_PERSON, person)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}