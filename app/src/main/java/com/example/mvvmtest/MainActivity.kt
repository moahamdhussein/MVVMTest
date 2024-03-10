package com.example.mvvmtest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mvvmtest.allProductList.ProductList
import com.example.mvvmtest.favourite.FavoriteList
import com.example.mvvmtest.databinding.ActivityMainBinding
import com.example.mvvmtest.favourite.FavouriteViewModel
import com.example.mvvmtest.favourite.FavouriteViewModelFactory
import com.example.mvvmtest.localDataSource.ProductLocalDataSource
import com.example.mvvmtest.model.IProductRepo
import com.example.mvvmtest.model.ProductRepo
import com.example.mvvmtest.model.Products
import com.example.mvvmtest.remoteDataSource.ProductRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnProductList.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ProductList::class.java
                )
            )
        }

        binding.btnFav.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    FavoriteList::class.java
                )
            )
        }
    }
}