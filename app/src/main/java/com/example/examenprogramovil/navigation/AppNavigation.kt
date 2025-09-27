package com.example.examenprogramovil.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenprogramovil.features.dollar.presentation.DollarScreen
import com.example.examenprogramovil.features.login.presentation.LogInPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dollar.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screen.LogInPage.route) {
            LogInPage(
                onSuccess = {
                    navController.navigate(Screen.Dollar.route)
                }
            )
        }

        composable(Screen.Dollar.route) {
            DollarScreen()
        }

        // composable(Screen.GithubScreen.route) {
        //     GithubScreen(modifier = Modifier.padding())
        // }

        // composable(Screen.MoviesScreen.route) {
        //     MoviesScreen(modifier = Modifier.padding())
        // }

        // composable(Screen.Profile.route) {
        //     ProfileScreen()
        // }

        // composable(Screen.CardExamples.route) {
        //     CardScreen()
        // }
    }
}