package com.example.androidakademija.main.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidakademija.databinding.FragmentContactsBinding
import com.example.androidakademija.main.model.Person
import com.example.androidakademija.main.ui.contacts.adapter.ContactsRecyclerAdapter
import com.example.androidakademija.main.viewmodels.MainActivityViewModel

class ContactsFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.peopleList.observe(viewLifecycleOwner, Observer {
            val adapter = ContactsRecyclerAdapter(requireContext(), it)
            binding.recyclerView.adapter = adapter
        })
        return root
    }

    fun Person.getDetails() = "$firstName $lastName, $age, $oib"
}