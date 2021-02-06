package com.jgbravo.exchangemoney.data.dtos.out


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyOutDTO(
    @Json(name = "base")
    val base: String?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "rates")
    val ratesOutDTO: RatesOutDTO?
)