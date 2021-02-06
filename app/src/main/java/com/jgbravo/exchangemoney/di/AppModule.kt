package com.jgbravo.exchangemoney.di

import com.jgbravo.exchangemoney.data.remote.ExchangeApi
import com.jgbravo.exchangemoney.utils.Constants.EXCHANGE_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideExchangeApi(): ExchangeApi =
        Retrofit.Builder()
            .baseUrl(EXCHANGE_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ExchangeApi::class.java)
}