package com.example.hiltintegrationexample.ui.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.hiltintegrationexample.data.model.State
import com.example.hiltintegrationexample.databinding.FragmentNewsListBinding
import com.example.hiltintegrationexample.ui.newslist.adapter.NewsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsListFragment : Fragment() {
    private val viewModel by viewModels<NewsListViewModel>()
    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = checkNotNull(_binding)

    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        initAdapter()
        observerNewsList()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchNews()
    }

    private fun initAdapter() {
        adapter = NewsListAdapter()
        binding.rvNewsList.adapter = adapter
    }

    private fun observerNewsList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.newsItem.collect { state ->
                    when (state) {
                        is State.Loading -> showLoading(true)
                        is State.Success -> {
                            showLoading(state.data.isEmpty())
                            if (state.data.isEmpty()) {
                                showEmptyState(true)
                                return@collect
                            }
                            showEmptyState(false)
                            adapter.submitList(state.data)
                        }
                        is State.Error -> {
                            showLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun showEmptyState(isEmpty: Boolean) {
        binding.emptyState.root.isVisible = isEmpty
        binding.rvNewsList.isVisible = isEmpty.not()
        binding.progressBar.isVisible = isEmpty.not()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
        binding.rvNewsList.isVisible = isLoading.not()
        binding.emptyState.root.isVisible = isLoading.not()
    }
}
