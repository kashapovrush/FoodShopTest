package com.kashapovrush.common.model

data class Product(
    var id: Int,
    var categoryId: Int,
    var name: String,
    var description: String,
    var image: String,
    var priceCurrent: Int,
    var priceOld: Int,
    var measure: Int,
    var measureUnit: String,
    var energy: Double,
    var proteins: Double,
    var fats: Double,
    var carbohydrates: Double,
//    var tags: List<Int>
)
