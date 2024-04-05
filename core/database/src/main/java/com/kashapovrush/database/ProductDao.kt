package com.kashapovrush.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getList(): Flow<List<ProductInCartDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPaymentItem(product: ProductInCartDb)

    @Query("DELETE FROM products")
    suspend fun clearList()

    @Query("DELETE FROM products WHERE id=:id" )
    suspend fun deleteItem(id: Int)

    @Query("SELECT * FROM products WHERE id=:id")
    suspend fun getProductItem(id: Int): ProductInCartDb
}
