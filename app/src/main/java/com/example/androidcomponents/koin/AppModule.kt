package com.example.androidcomponents.koin

import com.example.androidcomponents.ui.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SignInViewModel() }
}