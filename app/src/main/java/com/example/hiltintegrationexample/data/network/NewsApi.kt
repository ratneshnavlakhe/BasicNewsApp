package com.example.hiltintegrationexample.data.network

import com.example.hiltintegrationexample.data.model.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = DEFAULT_COUNTRY,
        @Query("page") pageNum: Int = DEFAULT_PAGE_NUM,
        @Query("pageSize") pageSize: Int = DEFAULT_QUERY_PAGE_SIZE,
    ): Response<NewsListResponse>

    companion object {
        const val DEFAULT_QUERY_PAGE_SIZE = 20
        const val DEFAULT_PAGE_NUM = 1
        const val DEFAULT_COUNTRY = "in"
    }
}