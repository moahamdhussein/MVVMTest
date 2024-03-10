package com.example.mvvmtest.model

interface IProductRepo {
    suspend fun getAllProduct(): MutableList<Products>

    suspend fun getStoredProduct(): List<Products>

    suspend fun insertProduct(products: Products)

    suspend fun deleteProduct(products: Products)
}