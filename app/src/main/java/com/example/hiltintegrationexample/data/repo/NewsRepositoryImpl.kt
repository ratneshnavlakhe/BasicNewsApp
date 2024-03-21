package com.example.hiltintegrationexample.data.repo

import com.example.hiltintegrationexample.data.local.NewsLocalSource
import com.example.hiltintegrationexample.data.network.NewsApi
import com.example.hiltintegrationexample.data.repo.mapper.articleEntityListToArticleList
import com.example.hiltintegrationexample.domain.NewsRepo
import com.example.hiltintegrationexample.domain.Resource
import com.example.hiltintegrationexample.domain.model.Article
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl
@Inject
constructor(
    private val apiService: NewsApi,
    private val newsLocalSource: NewsLocalSource
) : NewsRepo {
    override suspend fun getNews(pageNumber: Int): Flow<Resource<List<Article>>> {
        return flow {
            val countryLocale = newsLocalSource.getNewsLocale()
            println("Country locale is $countryLocale")
            val response =
                apiService.getNews(
                    pageNum = pageNumber,
                    country = countryLocale
                )
            emit(
                response.body()?.articles?.let {
                    Resource.Success(
                        it.articleEntityListToArticleList()
                    )
                }!!
            )
        }
    }

    override suspend fun getCountryLocale(): String {
        return newsLocalSource.getNewsLocale()
    }

    override suspend fun saveCountryLocale(locale: String) {
        newsLocalSource.saveNewsLocale(locale)
    }
}