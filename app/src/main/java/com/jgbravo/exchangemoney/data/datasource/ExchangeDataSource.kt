package com.jgbravo.exchangemoney.data.datasource

import com.jgbravo.exchangemoney.data.entities.Currency
import com.jgbravo.exchangemoney.utils.Resource

interface ExchangeDataSource {

    suspend fun getCurrencies(base: String): Resource<Currency>
}