package com.jgbravo.exchangemoney.data.entities

data class Currency(
    val base: String,
    val date: String,
    val rates: HashMap<String, Double>?
)