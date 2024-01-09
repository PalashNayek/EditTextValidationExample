package com.palash.edittextvalidationexample

sealed class ValidationState {
    object Success : ValidationState()
    data class Error(val message: String) : ValidationState()
}
