package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.data.remote.CoinPapricaApi
import com.example.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp.data.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPapricaApi) :CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
