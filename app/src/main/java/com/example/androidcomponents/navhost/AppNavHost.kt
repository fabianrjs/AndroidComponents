package com.example.androidcomponents.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcomponents.ui.signin.SignInScreen
import com.example.androidcomponents.ui.signup.SignUpScreen
import com.example.androidcomponents.ui.components.ComponentsScreen
import com.example.androidcomponents.ui.components.networkchanges.ListeningNetworkChangesScreen

sealed class AppRoutes(val route: String) {
    object SignInScreen: AppRoutes("signInScreen")
    object SingUpScreen: AppRoutes("signUpScreen")
    object ComponentsScreen: AppRoutes("componentsScreen")
    object ListeningNetworkChangesScreen: AppRoutes("listeningNetworkChangesScreen")
}

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoutes.SignInScreen.route
    ) {
        composable(route = AppRoutes.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(route = AppRoutes.SingUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = AppRoutes.ComponentsScreen.route) {
            ComponentsScreen(navController = navController)
        }
        composable(route = AppRoutes.ListeningNetworkChangesScreen.route) {
            ListeningNetworkChangesScreen()
        }
    }
}
