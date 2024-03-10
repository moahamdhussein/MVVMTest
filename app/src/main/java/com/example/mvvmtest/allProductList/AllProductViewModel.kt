package com.example.mvvmtest.allProductList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtest.model.IProductRepo
import com.example.mvvmtest.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllProductViewModel(private val repo : IProductRepo):ViewModel() {
    private var _products: MutableLiveData<List<Products>> =MutableLiveData<List<Products>>()
    val products :LiveData<List<Products>> = _products
    init {
        getAllProduct()
    }
    fun getAllProduct(){
        viewModelScope.launch(Dispatchers.IO) {
           _products.postValue(repo.getAllProduct())
        }
    }
    fun addToFav(product :Products){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertProduct(product)
        }
    }
}