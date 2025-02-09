package com.example.androidcomponents.koin

import com.example.androidcomponents.ui.components.ComponentsViewModel
import com.example.androidcomponents.ui.components.networkchanges.ListeningNetworkChangesViewModel
import com.example.androidcomponents.ui.components.networkchanges.NetworkObserver
import com.example.androidcomponents.ui.signin.SignInViewModel
import com.example.androidcomponents.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SignInViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { ComponentsViewModel() }
    viewModel { ListeningNetworkChangesViewModel(NetworkObserver(get())) }
}
