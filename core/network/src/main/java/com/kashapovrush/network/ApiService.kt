package com.kashapovrush.network

import com.kashapovrush.network.modelDto.CategoryDto
import com.kashapovrush.network.modelDto.ProductDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("Categories.json")
    suspend fun getCategories(): List<CategoryDto>

    @GET("Products.json")
    suspend fun getProducts(): List<ProductDto>

}