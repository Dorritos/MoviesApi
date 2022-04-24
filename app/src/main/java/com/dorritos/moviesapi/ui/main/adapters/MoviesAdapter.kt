package com.dorritos.moviesapi.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.moviesapi.R
import com.dorritos.moviesapi.api.models.Result
import com.dorritos.moviesapi.utils.ImageLoader

class MoviesAdapter(private val dataSet: List<Result>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewMovieName: TextView = view.findViewById(R.id.textViewMovieName)
        val textViewMovieDesc: TextView = view.findViewById(R.id.textViewMovieDecription)
        val imageViewMovieIcon: ImageView = view.findViewById(R.id.imageViewMovieIcon)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.movie_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (dataSet.isNotEmpty()) {
            viewHolder.apply {
                textViewMovieName.text = dataSet[position].display_title
                textViewMovieDesc.text = dataSet[position].summary_short

                val imageUrl = dataSet[position].multimedia.src
                ImageLoader.setImage(imageUrl, imageViewMovieIcon)
            }
        }
    }

    override fun getItemCount() = dataSet.size

}