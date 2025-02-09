package com.example.androidcomponents.ui.components.networkchanges

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkObserver(context: Context) {

    companion object {
        private const val TAG = "NetworkObserver"
    }

    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    val isConnectedFlow: Flow<Boolean> = callbackFlow {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                Log.d(TAG, "onAvailable: $network")
                connectivityManager.getNetworkCapabilities(network)?.let {
                    if (it.hasCapability(NET_CAPABILITY_INTERNET)) {
                        trySend(true)
                    }
                }
            }

            override fun onLost(network: Network) {
                Log.d(TAG, "onLost: $network")
                trySend(false)
            }

            override fun onUnavailable() {
                Log.d(TAG, "onUnavailable")
                trySend(false)
            }

            override fun onCapabilitiesChanged(
                network: Network,
                capabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, capabilities)
                Log.d(TAG, "onCapabilitiesChanged: $network, $capabilities")
                if (capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                    trySend(true)
                } else {
                    trySend(false)
                }
            }
        }

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        Log.d(TAG, "registerNetworkCallback: $networkRequest")
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
        awaitClose {
            Log.d(TAG, "unregisterNetworkCallback")
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }
}
