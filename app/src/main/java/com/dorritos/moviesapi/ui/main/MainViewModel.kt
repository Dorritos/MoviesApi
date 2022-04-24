package com.dorritos.moviesapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dorritos.moviesapi.Repository
import com.dorritos.moviesapi.api.models.Movies

class MainViewModel : ViewModel() {

    private val repository = Repository()
    private var movie = MutableLiveData<Movies>()

    init {
        movie = repository.getMovies()
    }

    fun getMovies(): LiveData<Movies> = movie
}