package com.kashapovrush.foodshoptest.di

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

    }
}