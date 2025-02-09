package com.example.androidcomponents.ui.components.networkchanges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ListeningNetworkChangesViewModel(
    networkObserver: NetworkObserver
): ViewModel() {

    val isConnected = networkObserver.isConnectedFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = false
    )
}
