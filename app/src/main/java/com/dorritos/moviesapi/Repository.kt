package com.dorritos.moviesapi

import androidx.lifecycle.MutableLiveData
import com.dorritos.moviesapi.api.RetrofitService
import com.dorritos.moviesapi.api.models.Movies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    private val api = RetrofitService.getInstance().getApi()

    fun getMovies() : MutableLiveData<Movies> {
        val movie = MutableLiveData<Movies>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getMovies(BuildConfig.API_KEY)
            movie.postValue(response)
        }
        return movie
    }
}