package com.dorritos.moviesapi.api

import com.dorritos.moviesapi.api.models.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getMovies(@Query("api-key") apiKey: String) : Movies
}