package com.game.vivocompose.app.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SignupViewModel @Inject constructor(): ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onEmailChanged(email: String) {
        _email.value = email
    }
    fun onPassChanged(pass: String) {
        _password.value = pass
    }
    fun onConfirmPassChanged(confPass: String) {
        _confirmPassword.value = confPass
    }
}