package com.jgbravo.exchangemoney.data.datasource

import android.util.Log
import com.jgbravo.exchangemoney.data.dtos.mappers.map
import com.jgbravo.exchangemoney.data.entities.Currency
import com.jgbravo.exchangemoney.data.remote.ExchangeApi
import com.jgbravo.exchangemoney.utils.Resource
import com.squareup.moshi.JsonDataException
import javax.inject.Inject

class ExchangeDataSourceImpl @Inject constructor(
    private val exchangeApi: ExchangeApi
) : ExchangeDataSource {

    override suspend fun getCurrencies(currencyBase: String): Resource<Currency> = try {
        val response = exchangeApi.getCurrency(currencyBase)
        val data = response.body()
        Log.d(javaClass.simpleName.toString(), response.message())
        if (response.isSuccessful && data != null) {
            try {
                Resource.Success(data.map())
            } catch (e: Exception) {
                Resource.Error("Error al mappear el inDTO a entity")
            }
        } else {
            Resource.Error("Error ${response.code()}: ${response.errorBody()}")
        }
    } catch (e: JsonDataException) {
        Resource.Error("Error al convertir el JSON a inDTO.")
    } catch (e: Exception) {
        Resource.Error(e.message ?: "Error en la llamada al servicio.")
    }
}