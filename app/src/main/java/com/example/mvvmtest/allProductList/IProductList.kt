package com.example.mvvmtest.allProductList

import com.example.mvvmtest.model.Products

interface IProductList {
    fun onSaveClick(product: Products)
}