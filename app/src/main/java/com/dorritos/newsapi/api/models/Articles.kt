package com.dorritos.newsapi.api.models

data class Articles(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)