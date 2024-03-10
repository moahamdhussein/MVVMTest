package com.example.mvvmtest.remoteDataSource

import com.example.mvvmtest.model.Products

interface IProductRemoteDataSource {
    suspend fun getAllProduct(): MutableList<Products>
}