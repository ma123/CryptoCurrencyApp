package com.example.cryptocurrencyapp.di

import androidx.compose.ui.unit.Constraints
import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.data.remote.CoinPapricaApi
import com.example.cryptocurrencyapp.data.repository.CoinRepository
import com.example.cryptocurrencyapp.domain.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaAPI(): CoinPapricaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinPapricaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}