package com.example.androidcomponents.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {

    private val _emailOrUsername = MutableStateFlow("")
    val emailOrUsername = _emailOrUsername.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _signInLoading = MutableStateFlow(false)
    val signInLoading = _signInLoading.asStateFlow()

    fun setPassword(newValue: String) {
        _password.value = newValue
    }

    fun setEmailOrUsername(newValue: String) {
        _emailOrUsername.value = newValue
    }

    fun signIn() {
        // TODO Repository call returning a flow
        _signInLoading.value = true
        viewModelScope.launch {
            delay(5000)
            _signInLoading.value = false
        }
    }
}
