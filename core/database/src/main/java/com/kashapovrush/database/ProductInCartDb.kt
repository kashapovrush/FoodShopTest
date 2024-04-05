package com.kashapovrush.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductInCartDb (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val count: Int,
    val priceCurrent: Int,
    val priceOld: Int
)
