package com.example.mvvmtest.allProductList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest.databinding.ActivityProductListBinding
import com.example.mvvmtest.localDataSource.ProductLocalDataSource
import com.example.mvvmtest.model.IProductRepo
import com.example.mvvmtest.model.ProductRepo
import com.example.mvvmtest.model.Products
import com.example.mvvmtest.remoteDataSource.ProductRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "ProductList"

class ProductList : AppCompatActivity(), IProductList {
    private lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: AllProductViewModel
    lateinit var factory: AllProductViewModelFactory
    lateinit var manager: LinearLayoutManager
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = AllProductViewModelFactory(
            ProductRepo.getInstance(
                remoteDataSource = ProductRemoteDataSource.getInstance(),
                localDataSource = ProductLocalDataSource(this)
            )
        )
        viewModel = ViewModelProvider(this, factory).get(AllProductViewModel::class.java)
        manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.HORIZONTAL
        adapter = Adapter(this)
        binding.myRecyclerView.layoutManager = manager
        binding.myRecyclerView.adapter = adapter

        viewModel.products.observe(this){

                Log.i(TAG, "onCreate: ${it.size}")
                adapter.submitList(it)

        }
    }
    override fun onSaveClick(product : Products){
        viewModel.addToFav(product)
    }

}