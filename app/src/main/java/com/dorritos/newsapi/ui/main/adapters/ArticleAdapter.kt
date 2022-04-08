package com.dorritos.newsapi.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.newsapi.R
import com.dorritos.newsapi.api.models.Article
import com.dorritos.newsapi.utils.ImageLoader

class ArticleAdapter(private val dataSet: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewArticleName: TextView = view.findViewById(R.id.textViewArticleName)
        val textViewArticleContent: TextView = view.findViewById(R.id.textViewArticleContent)
        val imageViewArticleIcon: ImageView = view.findViewById(R.id.imageViewArticleIcon)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.article_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            textViewArticleName.text = dataSet[position].title
            textViewArticleContent.text = dataSet[position].description

            val imageUrl = dataSet[position].urlToImage
            ImageLoader.setImage(imageUrl, imageViewArticleIcon)
        }
    }

    override fun getItemCount() = dataSet.size
}