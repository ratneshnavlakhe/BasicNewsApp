package com.example.hiltintegrationexample.ui.settings.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.hiltintegrationexample.MainCoroutineRule
import com.example.hiltintegrationexample.domain.FakeNewsRepo
import com.example.hiltintegrationexample.domain.NewsRepo
import com.example.hiltintegrationexample.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.pauseDispatcher
import kotlinx.coroutines.test.resumeDispatcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SettingsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var newsRepo: NewsRepo

    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setuup() {
        newsRepo = FakeNewsRepo()

        viewModel = SettingsViewModel(newsRepo)
    }

    @Test
    fun getNewsLocale_updateNewsLocale() {
        viewModel.updateNewsLocale("en")

        mainCoroutineRule.pauseDispatcher()

        viewModel.getNewsLocale()

        mainCoroutineRule.resumeDispatcher()

        assertThat(viewModel.newsLocale.getOrAwaitValue(), `is`("en"))
    }
}