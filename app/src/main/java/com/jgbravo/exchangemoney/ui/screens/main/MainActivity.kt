package com.jgbravo.exchangemoney.ui.screens.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jgbravo.exchangemoney.databinding.ActivityMainBinding
import com.jgbravo.exchangemoney.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnConvert.setOnClickListener {
                applicationContext.hideKeyboard(it)
                viewModel.convert(
                    etFrom.text.toString(),
                    spFromCurrency.selectedItem.toString(),
                    spToCurrency.selectedItem.toString()
                )
            }
        }

        collectFlows()
    }

    private fun collectFlows() {
        lifecycleScope.launchWhenCreated {
            viewModel.exchange.collect { state ->
                when (state) {
                    MainViewModel.ExchangeState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is MainViewModel.ExchangeState.Error -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            tvResult.setTextColor(Color.RED)
                            tvResult.text = state.errorText
                        }
                    }
                    is MainViewModel.ExchangeState.Success -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            tvResult.setTextColor(Color.BLACK)
                            tvResult.text = state.resultText
                        }
                    }
                    else -> Unit
                }
            }
        }
    }
}