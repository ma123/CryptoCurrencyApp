package com.example.cryptocurrencyapp.domain.model

import com.example.cryptocurrencyapp.data.remote.dto.CoinDto


data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)


fun CoinDto.toCoin(): Coin {
    return Coin (
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol
    )
}