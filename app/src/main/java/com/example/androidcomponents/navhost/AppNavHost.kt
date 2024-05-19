package com.example.androidcomponents.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcomponents.ui.home.HomeScreen
import com.example.androidcomponents.ui.signin.SignInScreen

sealed class AppRoutes(val route: String) {
    object SignInScreen: AppRoutes("signInScreen")
    object HomeScreen: AppRoutes("homeScreen")
}

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoutes.SignInScreen.route
    ) {
        composable(route = AppRoutes.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(route = AppRoutes.HomeScreen.route) {
            HomeScreen()
        }
    }
}
