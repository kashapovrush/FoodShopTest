package com.kashapovrush.navigation

import android.net.Uri
import com.google.gson.Gson
import com.kashapovrush.common.model.Product

sealed class Screen(val route: String) {


    data object SplashScreen: Screen(ROUTE_SPLASH_SCREEN)
    data object MenuScreen: Screen(ROUTE_MENU_SCREEN)

    data object CartScreen: Screen(ROUTE_CART_SCREEN)
    data object ItemCarScreen: Screen(ROUTE_ITEM_CARD_SCREEN) {

        const val ROUTE_ITEM_CARD_FOR_ARGS = "item_card_screen"

        fun getRouteWithArgs(product: Product): String {
            val productJson = Gson().toJson(product)
            return "${ROUTE_ITEM_CARD_FOR_ARGS}/${Uri.encode(productJson)}"
        }
    }

    companion object {

        const val ROUTE_CART_SCREEN = "cart_screen"
        const val ROUTE_SPLASH_SCREEN = "splash_screen"
        const val ROUTE_MENU_SCREEN = "menu_screen"
        const val ROUTE_ITEM_CARD_SCREEN = "item_card_screen/{product}"
    }
}