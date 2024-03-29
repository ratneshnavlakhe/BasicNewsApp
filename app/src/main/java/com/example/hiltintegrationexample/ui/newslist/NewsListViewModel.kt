package com.example.hiltintegrationexample.ui.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltintegrationexample.data.model.State
import com.example.hiltintegrationexample.domain.NewsRepo
import com.example.hiltintegrationexample.domain.model.Article
import com.example.hiltintegrationexample.ui.common.SingleLiveEvent
import com.example.hiltintegrationexample.ui.newslist.navigation.NewsListNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class NewsListViewModel
@Inject
constructor(
    private val newsRepo: NewsRepo
) : ViewModel() {
    private val _newsItem: MutableStateFlow<State<List<Article>>> =
        MutableStateFlow(State.loading())
    val newsItem: StateFlow<State<List<Article>>> = _newsItem

    var navigation = SingleLiveEvent<NewsListNavigation>()
        private set

    fun fetchNews() {
        viewModelScope.launch {
            newsRepo.getNews()
                .map { resource -> State.fromResource(resource) }
                .collect { state -> _newsItem.value = state }
        }
    }

    fun onNewsItemClick(article: Article) {
        navigation.value = NewsListNavigation.NavigateToWebView(article)
    }
}