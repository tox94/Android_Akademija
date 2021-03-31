package com.example.androidakademija.main.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidakademija.databinding.FragmentAddBinding
import com.example.androidakademija.main.model.Gender
import com.example.androidakademija.main.model.Person
import com.example.androidakademija.main.viewmodels.MainActivityViewModel

class AddPersonFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private var currentGender = Gender.MALE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.radioGroup.radioMale.setOnClickListener { currentGender = Gender.MALE }
        binding.radioGroup.female.setOnClickListener { currentGender = Gender.FEMALE }
        binding.radioGroup.other.setOnClickListener { currentGender = Gender.OTHER }
        binding.buttonAdd.setOnClickListener {
            if (binding.editImageUrl.validate() && binding.editStringFirstName.validate() && binding.editStringLastName.validate() && binding.editStringAge.validate() && binding.editStringOib.validate()) {
                val person = Person(
                    "https://www.sofascore.com/static/images/apple-icon-180x180.png",
                    binding.editStringFirstName.getCurrentText(),
                    binding.editStringLastName.getCurrentText(),
                    binding.editStringAge.getCurrentText().toInt(),
                    binding.editStringOib.getCurrentText().toLong(),
                    currentGender
                )
                viewModel.addPerson(person)
                binding.editImageUrl.reset()
                binding.editStringFirstName.reset()
                binding.editStringLastName.reset()
                binding.editStringAge.reset()
                binding.editStringOib.reset()
            }
        }
        return root
    }

}