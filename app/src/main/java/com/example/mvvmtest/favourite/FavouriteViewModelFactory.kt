package com.example.mvvmtest.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.model.IProductRepo


class FavouriteViewModelFactory(private val repo: IProductRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FavouriteViewModel::class.java)){
            FavouriteViewModel(repo) as T
        }else{
            throw IllegalArgumentException("View model class not found")
        }
    }
}