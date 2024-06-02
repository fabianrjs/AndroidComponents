package com.example.androidcomponents.koin

import com.example.androidcomponents.ui.signin.SignInViewModel
import com.example.androidcomponents.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SignInViewModel() }
    viewModel { SignUpViewModel() }
}
