package com.example.mvvmtest.favourite

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest.R
import com.example.mvvmtest.allProductList.Adapter
import com.example.mvvmtest.databinding.FavoriteItemBinding
import com.example.mvvmtest.model.Products

private const val TAG = "FavAdapter"

class FavAdapter(var data: List<Products>,val listener:IFavoriteList) : RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    lateinit var binding: FavoriteItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavAdapter.ViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.favorite_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavAdapter.ViewHolder, position: Int) {
        val current: Products = data.get(holder.adapterPosition)
        binding.product = current
        Log.i(TAG, "onBindViewHolder: " + current.toString())
        binding.btnRemove.setOnClickListener { listener.onRemoveClick(current) }
    }

    fun setList(list: List<Products>) {
        data = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(binding: FavoriteItemBinding) : RecyclerView.ViewHolder(binding.root)
}