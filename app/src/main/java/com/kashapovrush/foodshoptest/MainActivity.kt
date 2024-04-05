package com.kashapovrush.foodshoptest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kashapovrush.cart.CartScreen
import com.kashapovrush.common.viewmodel.MenuViewModel
import com.kashapovrush.database.ProductDao
import com.kashapovrush.itemcard.ItemCardScreen
import com.kashapovrush.menu.MenuScreen
import com.kashapovrush.navigation.AppNavGraph
import com.kashapovrush.navigation.Screen
import com.kashapovrush.navigation.rememberNavigationState
import com.kashapovrush.palette.FoodShopTestTheme
import com.kashapovrush.splashcreen.SplashScreenWithDelay
import com.kashapovrush.utils.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MenuViewModel

    private val component by lazy {
        (application as FoodShopApp).component
    }

    @Inject
    lateinit var productDao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {

            val navigationState = rememberNavigationState()
            viewModel = viewModel(factory = viewModelFactory)

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
                    },

                    cartScreenContent = {
                        FoodShopTestTheme(isSplashScreen = false) {
                            CartScreen()
                        }

                    })
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivityTest", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivityTest", "OnPause")
        CoroutineScope(Dispatchers.IO).launch {
            productDao.clearList()
        }
    }


}
