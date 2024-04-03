package com.kashapovrush.foodshoptest.di

import androidx.lifecycle.ViewModel
import com.kashapovrush.common.viewmodel.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModuleKey(MenuViewModel::class)
    fun provideMenuViewModel(viewModel: MenuViewModel): ViewModel

}