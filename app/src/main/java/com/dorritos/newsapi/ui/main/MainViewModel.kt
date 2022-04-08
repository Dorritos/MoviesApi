package com.dorritos.newsapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dorritos.newsapi.Repository
import com.dorritos.newsapi.api.models.Articles

class MainViewModel : ViewModel() {

    private val repository = Repository()
    private var articles = MutableLiveData<Articles>()

    init {
        articles = repository.getArticles()
    }

    fun getArticles(): LiveData<Articles> = articles
}