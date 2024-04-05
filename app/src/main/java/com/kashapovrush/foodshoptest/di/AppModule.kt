package com.kashapovrush.foodshoptest.di

import android.app.Application
import com.kashapovrush.database.AppDatabase
import com.kashapovrush.database.ProductDao
import com.kashapovrush.network.ApiFactory
import com.kashapovrush.network.ApiService
import com.kashapovrush.utils.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }


        @ApplicationScope
        @Provides
        fun provideProductDao(application: Application): ProductDao {
            return AppDatabase.getInstance(application).productDao()
        }

    }
}