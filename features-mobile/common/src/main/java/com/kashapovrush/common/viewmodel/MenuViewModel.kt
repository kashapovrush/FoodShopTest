package com.kashapovrush.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kashapovrush.common.mapper.FoodMapper
import com.kashapovrush.common.model.Product
import com.kashapovrush.common.state.MenuState
import com.kashapovrush.network.ApiService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val apiService: ApiService,
    private val mapper: FoodMapper
) : ViewModel() {

    private val _state = MutableLiveData<MenuState>(MenuState.Loading)
    val state: LiveData<MenuState> = _state


    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    suspend fun getCategories() = flow {
        emit(apiService.getCategories())
    }.map {
        mapper.mapCategoryDtoListToCategoryList(it)
    }.catch {

    }.collect {
        _state.postValue(MenuState.ResultCategories(listCategories = it))
    }

    suspend fun getProducts() = flow {
        emit(apiService.getProducts())
    }.map {
        mapper.mapProductDtoListToProductList(it)
    }.catch {
        _error.postValue(it.message)
    }.collect {
        _products.postValue(it)
    }
}