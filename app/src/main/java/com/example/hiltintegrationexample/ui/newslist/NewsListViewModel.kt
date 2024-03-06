package com.example.hiltintegrationexample.ui.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltintegrationexample.data.model.State
import com.example.hiltintegrationexample.domain.NewsRepo
import com.example.hiltintegrationexample.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel
    @Inject
    constructor(
        private val newsRepo: NewsRepo,
    ) : ViewModel() {
        private val _newsItem: MutableStateFlow<State<List<Article>>> =
            MutableStateFlow(State.loading())
        val newsItem: StateFlow<State<List<Article>>> = _newsItem

        fun fetchNews() {
            viewModelScope.launch {
                newsRepo.getNews()
                    .map { resource -> State.fromResource(resource) }
                    .collect { state -> _newsItem.value = state }
            }
        }
    }
