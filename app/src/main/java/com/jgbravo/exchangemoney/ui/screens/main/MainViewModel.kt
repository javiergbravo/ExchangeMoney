package com.jgbravo.exchangemoney.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgbravo.exchangemoney.data.datasource.ExchangeDataSource
import com.jgbravo.exchangemoney.utils.DispatcherProvider
import com.jgbravo.exchangemoney.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.round

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: ExchangeDataSource,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class ExchangeState {
        object NotStarted : ExchangeState()
        object Loading : ExchangeState()
        class Success(val resultText: String) : ExchangeState()
        class Error(val errorText: String) : ExchangeState()
    }

    private val _exchange = MutableStateFlow<ExchangeState>(ExchangeState.NotStarted)
    val exchange: StateFlow<ExchangeState> = _exchange

    fun convert(
        amount: String,
        fromCurrency: String,
        toCurrency: String
    ) {
        val fromAmount = amount.toFloatOrNull()
        if (fromAmount == null) {
            _exchange.value = ExchangeState.Error("Not valid amount.")
            return
        }
        if (fromCurrency == toCurrency) {
            _exchange.value = ExchangeState.Error(
                "You need to select different currencies to exchange."
            )
            return
        }

        viewModelScope.launch(dispatchers.io) {
            _exchange.value = ExchangeState.Loading
            val ratesResponse = dataSource.getCurrencies(fromCurrency)
            when (ratesResponse) {
                is Resource.Error -> _exchange.value = ExchangeState.Error(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.rates
                    val rate = rates?.get(toCurrency)
                    if (rate == null) {
                        _exchange.value = ExchangeState.Error("Unexpected error.")
                    } else {
                        val convertedCurrency = round(fromAmount * rate * 100) / 100
                        _exchange.value = ExchangeState.Success(
                            "$fromAmount $fromCurrency = $convertedCurrency $toCurrency"
                        )
                    }
                }
            }
        }
    }
}