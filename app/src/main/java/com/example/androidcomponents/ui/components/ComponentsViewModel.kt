package com.example.androidcomponents.ui.components

import androidx.lifecycle.ViewModel
import com.example.androidcomponents.navhost.AppRoutes

class ComponentsViewModel: ViewModel() {

    val components: List<Component> = getComponentsList()

    private fun getComponentsList(): List<Component> {
        val componentsList = mutableListOf<Component>()

        componentsList.add(
            Component(
                id = 1,
                name = "Listening to Network Changes",
                route = AppRoutes.ListeningNetworkChangesScreen.route
            )
        )

        return componentsList
    }
}

data class Component(
    val id: Int,
    val name: String,
    val route: String,
)
