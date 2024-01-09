package com.palash.edittextvalidationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.edtView)
        val validateButton = findViewById<Button>(R.id.btnSubmit)
        val resultTextView = findViewById<TextView>(R.id.txtView)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        editText.doAfterTextChanged { text ->
            mainViewModel.validateInput(text.toString())
        }

        mainViewModel.validationLiveData.observe(this, { validationState ->
            when (validationState) {
                is ValidationState.Success -> {
                    resultTextView.text = "Input is valid!"
                }
                is ValidationState.Error -> {
                    resultTextView.text = validationState.message
                }
            }
        })
    }
}