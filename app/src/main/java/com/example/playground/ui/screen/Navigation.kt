package com.example.playground.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object NavDestination {
    val HOME: String = "home"
}

@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController()
)  {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            val countryListViewModel: CountryListViewModel = viewModel(
                factory = CountryListViewModel.Factory
            )

            countryListViewModel.load()
            val uiState = countryListViewModel.uiState
            CountryListRoute(uiState)
        }
    }
}