package com.zybooks.assignment_7.network

import com.zybooks.assignment_7.model.CurrencyResponse
import retrofit2.http.GET

interface CurrencyApi {
    @GET("v6/latest/USD")
    suspend fun getRates(): CurrencyResponse
}
