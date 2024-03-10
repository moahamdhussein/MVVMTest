package com.example.mvvmtest.favourite

import com.example.mvvmtest.model.Products

interface IFavoriteList {
    fun onRemoveClick(product: Products)
}