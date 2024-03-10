package com.example.mvvmtest.favourite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mvvmtest.databinding.ActivityFavoriteListBinding
import com.example.mvvmtest.localDataSource.ProductLocalDataSource
import com.example.mvvmtest.model.IProductRepo
import com.example.mvvmtest.model.ProductRepo
import com.example.mvvmtest.model.Products
import com.example.mvvmtest.remoteDataSource.ProductRemoteDataSource

class FavoriteList : AppCompatActivity(), IFavoriteList {
    private lateinit var viewModel: FavouriteViewModel
    private lateinit var binding: ActivityFavoriteListBinding
    private lateinit var favFactory: FavouriteViewModelFactory
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: FavAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.HORIZONTAL
        binding.myRecyclerView.layoutManager = manager
        adapter= FavAdapter(listOf(),this)
        binding.myRecyclerView.adapter = adapter

        favFactory = FavouriteViewModelFactory(ProductRepo.getInstance(
            ProductRemoteDataSource.getInstance(),
            ProductLocalDataSource(this)
        ))
        viewModel = ViewModelProvider(this, favFactory).get(FavouriteViewModel::class.java)
        viewModel.products.observe(this) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }
    override fun onRemoveClick(product:Products){
        viewModel.deleteProduct(product)
    }

}