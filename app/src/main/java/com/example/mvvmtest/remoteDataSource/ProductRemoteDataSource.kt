package com.example.mvvmtest.remoteDataSource

import com.example.mvvmtest.model.Products

class ProductRemoteDataSource  private constructor() : IProductRemoteDataSource {
    private val productService: ApiService by lazy {
        RetrofitHelper.getInstance().create(ApiService::class.java)
    }
    override suspend fun getAllProduct(): MutableList<Products> {

        return productService.getProducts().body()?.products ?: mutableListOf()
    }
    companion object{
        private var instance:ProductRemoteDataSource? = null
        fun getInstance():ProductRemoteDataSource{
            return instance ?: synchronized(this){
                val temp = ProductRemoteDataSource()
                instance =temp
                temp
            }
        }
    }
}