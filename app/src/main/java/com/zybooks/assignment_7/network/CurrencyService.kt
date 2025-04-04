package com.zybooks.assignment_7.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyService {
    private const val BASE_URL = "https://api.exchangerate.host/"

    val api: CurrencyApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }
}
