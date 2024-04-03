package com.kashapovrush.foodshoptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.common.viewmodel.MenuViewModel
import com.kashapovrush.itemcard.ItemCardScreen
import com.kashapovrush.menu.MenuScreen
import com.kashapovrush.navigation.AppNavGraph
import com.kashapovrush.navigation.Screen
import com.kashapovrush.navigation.rememberNavigationState
import com.kashapovrush.palette.FoodShopTestTheme
import com.kashapovrush.splashcreen.SplashScreenWithDelay
import com.kashapovrush.utils.ViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as FoodShopApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {

            val navigationState = rememberNavigationState()
            val viewModel: MenuViewModel = viewModel(factory = viewModelFactory)

            FoodShopTestTheme(darkTheme = false, dynamicColor = false, isSplashScreen = true) {
                AppNavGraph(
                    navHostController = navigationState.navHostController,
                    splashScreenContent = {
                        SplashScreenWithDelay {
                            navigationState.navigateTo(Screen.MenuScreen.route)
                        }
                    },
                    menuScreenContent = {
                        FoodShopTestTheme(isSplashScreen = false) {
                            MenuScreen(
                                viewModel = viewModel,
                                owner = this,
                                navigationState = navigationState
                            )

                        }
                    },
                    itemCardScreenContent = {
                        ItemCardScreen(it, navigationState)
                    })
            }
        }
    }
}
