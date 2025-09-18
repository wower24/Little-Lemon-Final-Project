package com.wower.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController: NavHostController,
    isLoggedIn: Boolean,
    menuItems: List<MenuItemRoom> = listOf()
) {
    //TODO: startDestination based on isLoggedIn shared preference
    val startDestination = if (isLoggedIn) Home.route else Onboarding.route
    val navHost = NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            Onboarding(navController)
        }

        composable(Home.route) {
            Home(
                navController,
                menuItems
            )
        }

        composable(Profile.route) {
            Profile(navController)
        }
    }
}