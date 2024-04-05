package com.kashapovrush.common.model

data class ProductInCart(
    val id: Int,
    val name: String,
    val count: Int,
    val priceCurrent: Int,
    val priceOld: Int
)
