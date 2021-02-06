package com.jgbravo.exchangemoney.data.dtos.mappers

import com.jgbravo.exchangemoney.data.dtos.`in`.CurrencyInDTO
import com.jgbravo.exchangemoney.data.dtos.`in`.RatesInDTO
import com.jgbravo.exchangemoney.data.entities.Currency
import com.jgbravo.exchangemoney.data.entities.Rate

fun CurrencyInDTO.map() = Currency(
    base = base!!,
    date = date!!,
    rate = ratesInDTO?.map()
)

fun RatesInDTO.map() = Rate(
    eUR = eUR,
    aUD = aUD,
    bGN = bGN,
    bRL = bRL,
    cAD = cAD,
    cHF = cHF,
    cNY = cNY,
    cZK = cZK,
    dKK = dKK,
    gBP = gBP,
    hKD = hKD,
    hRK = hRK,
    hUF = hUF,
    iDR = iDR,
    iLS = iLS,
    iNR = iNR,
    iSK = iSK,
    jPY = jPY,
    kRW = kRW,
    mXN = mXN,
    mYR = mYR,
    nOK = nOK,
    nZD = nZD,
    pHP = pHP,
    pLN = pLN,
    rON = rON,
    rUB = rUB,
    sEK = sEK,
    sGD = sGD,
    tHB = tHB,
    tRY = tRY,
    uSD = uSD,
    zAR = zAR
)