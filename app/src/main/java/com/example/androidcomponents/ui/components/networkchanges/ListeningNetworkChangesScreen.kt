package com.example.androidcomponents.ui.components.networkchanges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListeningNetworkChangesScreen(
    viewModel: ListeningNetworkChangesViewModel = koinViewModel()
) {
    val isConnected by viewModel.isConnected.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isConnected) {
            Text("Internet Connection Available")
        } else {
            Text("Disconnected")
        }
    }
}
