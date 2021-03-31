package com.example.androidakademija.main.ui.settings

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.androidakademija.R
import com.example.androidakademija.databinding.FragmentSettingsBinding
import com.example.androidakademija.helpers.LanguageHelper
import com.example.androidakademija.main.MainActivity

const val LANGUAGE_EN = "en"
const val LANGUAGE_HR = "hr"

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private var firstSelection = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val languageArray = requireContext().resources.getStringArray(R.array.available_languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.text_view_row, languageArray)
        binding.languageSpinner.adapter = arrayAdapter
        val currentLanguageCode = LanguageHelper.getPreferredLanguage(requireContext())
        if (currentLanguageCode == LANGUAGE_HR) {
            binding.languageSpinner.setSelection(1)
        }
        binding.languageSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    if (firstSelection) {
                        firstSelection = false
                    } else {
                        val item = parent.getItemAtPosition(position) as String
                        val tempLanguageCode = languageStringToCode(item)
                        if (tempLanguageCode != currentLanguageCode) {
                            LanguageHelper.setPreferredLanguage(requireContext(), tempLanguageCode)
                            restartApp()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // nothing happens
                }
            }

        return binding.root
    }

    private fun languageStringToCode(languageString: String): String {
        return when (languageString) {
            requireContext().getString(R.string.language_en) -> LANGUAGE_EN
            requireContext().getString(R.string.language_hr) -> LANGUAGE_HR
            else -> ""
        }
    }

    private fun restartApp() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(activity, MainActivity::class.java)
            val cn = intent.component
            val mainIntent = Intent.makeRestartActivityTask(cn)
            startActivity(mainIntent)
            Process.killProcess(Process.myPid())
        }, 300)
    }
}