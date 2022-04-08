package com.dorritos.newsapi.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoader {
    fun setImage(url: String, imageView: ImageView) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}