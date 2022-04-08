package com.dorritos.newsapi.api

import com.dorritos.newsapi.api.models.Articles
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String
    ) : Articles
}