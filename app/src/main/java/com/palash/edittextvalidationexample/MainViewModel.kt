package com.palash.edittextvalidationexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _validationLiveData = MutableLiveData<ValidationState>()
    val validationLiveData: LiveData<ValidationState> = _validationLiveData

    fun validateInput(input: String) {
        if (input.isEmpty()) {
            _validationLiveData.value = ValidationState.Error("Field cannot be empty")
        } else {
            // Add more validation logic here
            _validationLiveData.value = ValidationState.Success
        }
    }

}