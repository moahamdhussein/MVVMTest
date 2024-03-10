package com.example.mvvmtest.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtest.model.IProductRepo
import com.example.mvvmtest.model.ProductRepo
import com.example.mvvmtest.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel(private val repo : IProductRepo): ViewModel() {
    private var _products:MutableLiveData<List<Products>> = MutableLiveData<List<Products>>()
    val products:LiveData<List<Products>> = _products
    init {
        getLocalProduct()
    }

    fun getLocalProduct(){
        viewModelScope.launch (Dispatchers.IO){
            _products.postValue(repo.getStoredProduct())
        }
    }
    fun deleteProduct(product :Products){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteProduct(product)
            getLocalProduct()
        }
    }

}