package com.example.mvvmtest.localDataSource

import com.example.mvvmtest.model.Products

interface IProductLocalDataSource {
    suspend fun insertProduct(product: Products)
    suspend fun deleteProduct(product: Products)
    suspend fun getStoredProduct(): List<Products>
}