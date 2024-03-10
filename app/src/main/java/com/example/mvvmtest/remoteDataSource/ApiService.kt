package com.example.mvvmtest.remoteDataSource

import com.example.kotlinday5.model.UpperClassPojo
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<UpperClassPojo>
}