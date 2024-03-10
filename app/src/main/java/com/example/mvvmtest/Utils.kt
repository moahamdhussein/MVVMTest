package com.example.mvvmtest

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

private const val TAG = "Utils"


@BindingAdapter("setOnlineImage")
fun loadImage(view: ImageView, url: String?) {
    Log.i(TAG, "loadImage: ")
    url.let {
        Glide.with(view.context).load(it).into(view)
    }
}