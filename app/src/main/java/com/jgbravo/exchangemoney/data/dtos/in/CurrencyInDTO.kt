package com.jgbravo.exchangemoney.data.dtos.`in`


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyInDTO(
    @Json(name = "base")
    val base: String?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "rates")
    val ratesInDTO: RatesInDTO?
)