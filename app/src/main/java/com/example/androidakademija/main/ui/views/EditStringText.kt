package com.example.androidakademija.main.ui.views

import android.content.Context
import android.text.InputFilter
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.androidakademija.R
import com.example.androidakademija.databinding.EditTextStringBinding

const val TYPE_STRING = 0
const val TYPE_INT = 1
const val TYPE_LONG = 2

class EditStringText(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val binding: EditTextStringBinding
    private val dataType: Int
    private val dataLength: Int
    private val errorText: String

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.edit_text_string, null, false)
        binding = EditTextStringBinding.bind(view)
        addView(binding.root)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.EditStringText,
            0, 0
        ).apply {
            try {
                binding.firstNameTextView.text = getString(R.styleable.EditStringText_textViewText)
                binding.editTextFirstName.hint = getString(R.styleable.EditStringText_editTextHint)
                dataType = getInteger(R.styleable.EditStringText_dataType, 0)
                dataLength = getInteger(R.styleable.EditStringText_dataLength, 0)
                errorText = getString(R.styleable.EditStringText_errorText) ?: ""
                binding.editTextFirstName.inputType =
                    when (dataType) {
                        TYPE_STRING -> InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                        TYPE_INT -> InputType.TYPE_CLASS_NUMBER
                        TYPE_LONG -> InputType.TYPE_CLASS_NUMBER
                        else -> InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                    }
            } finally {
                recycle()
            }
        }
    }

    fun validate(): Boolean {
        return when (dataType) {
            TYPE_STRING, TYPE_LONG -> {
                if (dataLength > 0) {
                    if (!(binding.editTextFirstName.text.isNullOrEmpty()) && binding.editTextFirstName.text.length < dataLength) {
                        true
                    } else {
                        binding.editTextFirstName.error = errorText
                        false
                    }
                } else {
                    !(binding.editTextFirstName.text.isNullOrEmpty())
                }
            }
            TYPE_INT -> {
                if (dataLength > 0) {
                    binding.editTextFirstName.text?.let {
                        val value = it.toString().toInt()
                        if (value <= dataLength) {
                            true
                        } else {
                            showError()
                            false
                        }
                    } ?: let {
                        showError()
                        false
                    }
                } else {
                    binding.editTextFirstName.text?.let {
                        true
                    } ?: let {
                        showError()
                        false
                    }
                }
            }
            else -> {
                true
            }
        }
    }

    private fun showError() {
        binding.editTextFirstName.error = errorText
    }

    fun getCurrentText(): String {
        return binding.editTextFirstName.text.toString()
    }

    fun reset() {
        binding.editTextFirstName.text.clear()
    }
}