package com.jgbravo.exchangemoney.data.dtos.mappers

import com.jgbravo.exchangemoney.data.dtos.`in`.CurrencyInDTO
import com.jgbravo.exchangemoney.data.dtos.`in`.RatesInDTO
import com.jgbravo.exchangemoney.data.entities.Currency

fun CurrencyInDTO.map() = Currency(
    base = base!!,
    date = date!!,
    rates = ratesInDTO?.mapRates()
)

fun RatesInDTO.mapRates(): HashMap<String, Double> {
    val ratesHashMap = HashMap<String, Double>()
    eUR?.let { ratesHashMap.put("EUR", it) }
    aUD?.let { ratesHashMap.put("AUD", it) }
    bGN?.let { ratesHashMap.put("BGN", it) }
    bRL?.let { ratesHashMap.put("BRL", it) }
    cAD?.let { ratesHashMap.put("CAD", it) }
    cHF?.let { ratesHashMap.put("CHF", it) }
    cNY?.let { ratesHashMap.put("CNY", it) }
    cZK?.let { ratesHashMap.put("CZK", it) }
    dKK?.let { ratesHashMap.put("DKK", it) }
    gBP?.let { ratesHashMap.put("GBP", it) }
    hKD?.let { ratesHashMap.put("HKD", it) }
    hRK?.let { ratesHashMap.put("HRK", it) }
    hUF?.let { ratesHashMap.put("HUF", it) }
    iDR?.let { ratesHashMap.put("IDR", it) }
    iLS?.let { ratesHashMap.put("ILS", it) }
    iNR?.let { ratesHashMap.put("INR", it) }
    iSK?.let { ratesHashMap.put("ISK", it) }
    jPY?.let { ratesHashMap.put("JPY", it) }
    kRW?.let { ratesHashMap.put("KRW", it) }
    mXN?.let { ratesHashMap.put("MXN", it) }
    mYR?.let { ratesHashMap.put("MYR", it) }
    nOK?.let { ratesHashMap.put("NOK", it) }
    nZD?.let { ratesHashMap.put("NZD", it) }
    pHP?.let { ratesHashMap.put("PHP", it) }
    pLN?.let { ratesHashMap.put("PLN", it) }
    rON?.let { ratesHashMap.put("RON", it) }
    rUB?.let { ratesHashMap.put("RUB", it) }
    sEK?.let { ratesHashMap.put("SEK", it) }
    sGD?.let { ratesHashMap.put("SGD", it) }
    tHB?.let { ratesHashMap.put("THB", it) }
    tRY?.let { ratesHashMap.put("TRY", it) }
    uSD?.let { ratesHashMap.put("USD", it) }
    zAR?.let { ratesHashMap.put("ZAR", it) }
    return ratesHashMap
}