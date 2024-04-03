package com.kashapovrush.network.modelDto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price_current")
    val priceCurrent: Int,
    @SerializedName("price_old")
    val priceOld: Int,
    @SerializedName("measure")
    val measure: Int,
    @SerializedName("measure_unit")
    val measureUnit: String,
    @SerializedName("energy_per_100_grams")
    val energy: Double,
    @SerializedName("proteins_per_100_grams")
    val proteins: Double,
    @SerializedName("fats_per_100_grams")
    val fats: Double,
    @SerializedName("carbohydrates_per_100_grams")
    val carbohydrates: Double,
//    @SerializedName("tag_ids")
//    var tags: List<Int>
)

