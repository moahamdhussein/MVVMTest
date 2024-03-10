package com.example.mvvmtest.allProductList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.mvvmtest.model.IProductRepo

class AllProductViewModelFactory (private val repo: IProductRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AllProductViewModel::class.java)){
            AllProductViewModel(repo) as T
        }else{
            throw IllegalArgumentException("View model class not found")
        }
    }
}