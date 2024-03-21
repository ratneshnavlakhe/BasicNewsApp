package com.example.hiltintegrationexample.data.model

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<ArticleEntity>
)