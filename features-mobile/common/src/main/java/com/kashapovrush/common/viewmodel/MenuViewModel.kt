package com.kashapovrush.common.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kashapovrush.common.mapper.FoodMapper
import com.kashapovrush.common.model.Product
import com.kashapovrush.common.model.ProductInCart
import com.kashapovrush.common.state.MenuState
import com.kashapovrush.database.ProductDao
import com.kashapovrush.database.ProductInCartDb
import com.kashapovrush.network.ApiService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao,
    private val mapper: FoodMapper
) : ViewModel() {

    private val _state = MutableLiveData<MenuState>(MenuState.Loading)
    val state: LiveData<MenuState> = _state


    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    val productList = productDao.getList()
        .map {
            mapper.mapProductInCartDbListToProductInCartList(it)
        }.asLiveData()


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

    fun addPaymentItem(productInCart: ProductInCart) {
        viewModelScope.launch {
            productDao.addPaymentItem(mapper.mapProductInCartToProductInCartDb(productInCart))
        }

    }

    fun deleteItem(id: Int) {
        viewModelScope.launch {
            productDao.deleteItem(id)
        }
    }

    suspend fun getProductItem(id: Int): ProductInCart {
        return mapper.mapProductInCartDbToProductInCart(productDao.getProductItem(id))
    }

    fun clear() {
        viewModelScope.launch {
            productDao.clearList()
        }
    }
}