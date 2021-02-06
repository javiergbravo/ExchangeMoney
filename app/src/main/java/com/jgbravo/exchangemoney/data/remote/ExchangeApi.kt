package com.jgbravo.exchangemoney.data.remote

import com.jgbravo.exchangemoney.data.dtos.`in`.CurrencyInDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeApi {

    @GET("/latest")
    suspend fun getCurrency(
        @Query("base") base: String
    ): Response<CurrencyInDTO>
}