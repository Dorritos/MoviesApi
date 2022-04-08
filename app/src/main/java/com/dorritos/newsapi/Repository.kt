package com.dorritos.newsapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dorritos.newsapi.api.RetrofitService
import com.dorritos.newsapi.api.models.Articles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    private val api = RetrofitService.getInstance().getApi()

    fun getArticles() : MutableLiveData<Articles> {
        val article = MutableLiveData<Articles>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getArticles("ru", 1, BuildConfig.API_KEY)
            article.postValue(response)
        }
        return article
    }
}