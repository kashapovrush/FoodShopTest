package com.kashapovrush.foodshoptest

import android.app.Application
import com.kashapovrush.foodshoptest.di.DaggerAppComponent

class FoodShopApp: Application() {


    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}