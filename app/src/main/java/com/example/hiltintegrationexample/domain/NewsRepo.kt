package com.example.hiltintegrationexample.domain

import com.example.hiltintegrationexample.data.network.NewsApi
import com.example.hiltintegrationexample.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    suspend fun getNews(pageNumber: Int = NewsApi.DEFAULT_PAGE_NUM): Flow<Resource<List<Article>>>

    suspend fun getCountryLocale(): String

    suspend fun saveCountryLocale(locale: String)
}