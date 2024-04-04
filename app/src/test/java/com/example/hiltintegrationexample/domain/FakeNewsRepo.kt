package com.example.hiltintegrationexample.domain

import com.example.hiltintegrationexample.domain.model.Article
import kotlinx.coroutines.flow.Flow

class FakeNewsRepo : NewsRepo {

    private lateinit var countryLocale: String

    override suspend fun getNews(pageNumber: Int): Flow<Resource<List<Article>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCountryLocale(): String {
        return countryLocale
    }

    override suspend fun saveCountryLocale(locale: String) {
        countryLocale = locale
    }
}