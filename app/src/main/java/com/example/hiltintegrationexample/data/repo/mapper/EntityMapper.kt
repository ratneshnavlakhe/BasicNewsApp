package com.example.hiltintegrationexample.data.repo.mapper

import com.example.hiltintegrationexample.data.model.ArticleEntity
import com.example.hiltintegrationexample.data.model.SourceEntity
import com.example.hiltintegrationexample.domain.model.Article
import com.example.hiltintegrationexample.domain.model.Source

fun List<ArticleEntity>.articleEntityListToArticleList(): List<Article> {
    val list = mutableListOf<Article>()
    forEach { apiArticle ->
        list.add(apiArticle.articleEntityToArticle())
    }

    return list
}

fun ArticleEntity.articleEntityToArticle(): Article {
    return Article(
        source = source.sourceEntityToSource(),
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )
}


fun SourceEntity.sourceEntityToSource(): Source {
    return Source(
        id = id,
        name = name
    )
}