package com.example.androidcomponents.ui.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    private val _emailOrUsername = MutableStateFlow("")
    val emailOrUsername = _emailOrUsername.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _signInLoading = MutableStateFlow(false)
    val signInLoading = _signInLoading.asStateFlow()

    fun setPassword(newValue: String) {
        if (newValue.length <= 30) _password.value = newValue
    }

    fun setEmailOrUsername(newValue: String) {
        if (newValue.length <= 60) _emailOrUsername.value = newValue
    }

    fun signIn(navigateToHomeScreen: () -> Unit) {
        // TODO Repository call returning a flow
        _signInLoading.value = true
        viewModelScope.launch {
            delay(3000)
            _signInLoading.value = false
            navigateToHomeScreen()
        }
    }
}
