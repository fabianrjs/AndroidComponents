package com.example.androidcomponents.ui.signup

import androidx.lifecycle.viewModelScope
import com.example.androidcomponents.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel: BaseViewModel() {
    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()

    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _confirmedEmail = MutableStateFlow("")
    val confirmedEmail = _confirmedEmail.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _confirmedPassword = MutableStateFlow("")
    val confirmedPassword = _confirmedPassword.asStateFlow()

    private val _signUpLoading = MutableStateFlow(false)
    val signUpLoading = _signUpLoading.asStateFlow()

    fun setPassword(newValue: String) {
        if (newValue.length <= 30) _password.value = newValue
    }

    fun setConfirmedPassword(newValue: String) {
        if (newValue.length <= 30) _confirmedPassword.value = newValue
    }

    fun setEmail(newValue: String) {
        if (newValue.length <= 60) _email.value = newValue
    }

    fun setConfirmedEmail(newValue: String) {
        if (newValue.length <= 60) _confirmedEmail.value = newValue
    }

    fun setFirstName(newValue: String) {
        if (newValue.length <= 30) _firstName.value = newValue
    }

    fun setLastName(newValue: String) {
        if (newValue.length <= 30) _lastName.value = newValue
    }

    fun signUp(navigateToHomeScreen: () -> Unit) {
        // TODO Repository call returning a flow
        _signUpLoading.value = true
        viewModelScope.launch {
            delay(3000)
            _signUpLoading.value = false
            navigateToHomeScreen()
        }
    }
}
