package com.example.mvvmtest.localDataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmtest.model.Products

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table")
    suspend fun getAllProduct(): List<Products>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(products: Products)

    @Delete
    suspend fun deleteProduct(products: Products)
}