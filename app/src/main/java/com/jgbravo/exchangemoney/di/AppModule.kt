package com.jgbravo.exchangemoney.di

import com.jgbravo.exchangemoney.data.datasource.ExchangeDataSource
import com.jgbravo.exchangemoney.data.datasource.ExchangeDataSourceImpl
import com.jgbravo.exchangemoney.data.remote.ExchangeApi
import com.jgbravo.exchangemoney.utils.Constants.EXCHANGE_BASE_URL
import com.jgbravo.exchangemoney.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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

    @Singleton
    @Provides
    fun provideExchangeDataSource(api: ExchangeApi): ExchangeDataSource =
        ExchangeDataSourceImpl(api)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}