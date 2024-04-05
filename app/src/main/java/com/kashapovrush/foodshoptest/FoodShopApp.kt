package com.kashapovrush.foodshoptest

import android.app.Application
import com.kashapovrush.database.ProductDao
import com.kashapovrush.foodshoptest.di.DaggerAppComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodShopApp: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

}