package com.example.hiltintegrationexample.ui.newslist.navigation

import com.example.hiltintegrationexample.domain.model.Article

sealed class NewsListNavigation {
    data class NavigateToWebView(val item: Article) : NewsListNavigation()
}
