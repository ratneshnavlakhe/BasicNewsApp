package com.example.hiltintegrationexample.ui.settings.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltintegrationexample.domain.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel
@Inject
constructor(
    private val newsRepo: NewsRepo
) : ViewModel() {
    private val _newsLocale = MutableLiveData<String>()

    val newsLocale: LiveData<String> = _newsLocale

    fun updateNewsLocale(locale: String) {
        viewModelScope.launch {
            newsRepo.saveCountryLocale(locale)
        }
    }

    fun getNewsLocale() {
        viewModelScope.launch {
            _newsLocale.value = newsRepo.getCountryLocale()
        }
    }
}