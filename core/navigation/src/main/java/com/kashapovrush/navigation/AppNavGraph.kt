package com.kashapovrush.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.kashapovrush.common.model.Product

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    splashScreenContent: @Composable () -> Unit,
    menuScreenContent: @Composable () -> Unit,
    itemCardScreenContent: @Composable (Product) -> Unit
) {

    NavHost(navController = navHostController, startDestination = Screen.SplashScreen.route) {

        composable(Screen.SplashScreen.route) {
            splashScreenContent()
        }

        composable(Screen.MenuScreen.route) {
            menuScreenContent()
        }

        composable(Screen.ItemCarScreen.route,
            arguments = listOf(
                navArgument("product") {
                    type = NavType.StringType
                }
            )) {
            val productJson = it.arguments?.getString("product")
            val product = Gson().fromJson(productJson, Product::class.java)
            itemCardScreenContent(product)
        }

    }

}