package com.example.mvvmtest.allProductList

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest.model.Products
import com.example.mvvmtest.R
import com.example.mvvmtest.databinding.ProductItemBinding
import kotlin.math.log

private const val TAG = "ProductListAdapter"

class Adapter(val listener: IProductList) : ListAdapter<Products, Adapter.ViewHolder>(
    ProductDiff()
) {
    private lateinit var binding:ProductItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding =DataBindingUtil.inflate(inflater,R.layout.product_item, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentObject: Products = getItem(holder.adapterPosition)

        binding.product = currentObject
        Log.i(TAG, "onBindViewHolder: "+currentObject.title)
        binding.btnSave.setOnClickListener { listener.onSaveClick(currentObject) }
    }
    inner class ViewHolder(itemView: ProductItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    }
}

class ProductDiff : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        Log.i(TAG, "areItemsTheSame: ")
        return oldItem.title == newItem.title
    }
    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }

}