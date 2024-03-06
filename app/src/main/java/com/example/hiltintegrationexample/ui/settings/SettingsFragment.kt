package com.example.hiltintegrationexample.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hiltintegrationexample.databinding.FragmentSettingsBinding
import com.example.hiltintegrationexample.ui.settings.viewmodel.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private val viewModel by viewModels<SettingsViewModel>()
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        setUpObservers()
        setUpListeners()
        viewModel.getNewsLocale()
    }

    private fun setUpListeners() {
        binding.newsLocale.doAfterTextChanged {
            viewModel.updateNewsLocale(it.toString())
        }
    }

    private fun setUpObservers() {
        viewModel.newsLocale.observe(viewLifecycleOwner) {
            binding.newsLocale.setText(it)
        }
    }
}
