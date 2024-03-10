package com.example.mvvmtest.localDataSource

import android.content.Context
import com.example.mvvmtest.model.Products



class ProductLocalDataSource(context : Context) : IProductLocalDataSource {
    private val dao :ProductDao by lazy {
        val appDatabase = ProductDatabase.getInstance(context)
        appDatabase.getProductDao()
    }

    override suspend fun insertProduct(product:Products){
        dao.insertProduct(product)
    }

    override suspend fun deleteProduct(product:Products){
        dao.deleteProduct(product)
    }
    override suspend fun getStoredProduct():List<Products>{
       return dao.getAllProduct()
    }
}