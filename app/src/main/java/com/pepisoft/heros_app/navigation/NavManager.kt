package com.pepisoft.heros_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pepisoft.heros_app.viewModel.GamesViewModel
import com.pepisoft.heros_app.views.DetailView
import com.pepisoft.heros_app.views.HomeView
import com.pepisoft.heros_app.views.SearchGameView

@Composable
fun NavManager(viewModel: GamesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(viewModel, navController)
        }

        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )){
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(viewModel, navController, id)
        }

        composable("SearchGameView") {
            SearchGameView(viewModel = viewModel, navController)
        }
    }
}
