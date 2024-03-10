package com.example.kotlinday5.model

import com.example.mvvmtest.model.Products


data class UpperClassPojo(
    var products: MutableList<Products>,
    var total: Int,
    var skip: Int,
    var limit: Int,
)