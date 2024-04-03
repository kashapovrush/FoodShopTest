package com.kashapovrush.foodshoptest.di

import android.app.Application
import com.kashapovrush.foodshoptest.MainActivity
import com.kashapovrush.utils.ApplicationScope
import dagger.BindsInstance
import dagger.Component
@ApplicationScope
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject (activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create (@BindsInstance application: Application): AppComponent
    }
}