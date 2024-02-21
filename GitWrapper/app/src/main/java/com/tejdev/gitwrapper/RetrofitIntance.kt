package com.tejdev.gitwrapper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIntance {
    private const val baseUrl = "https://api.dictionaryapi.dev/api/v2/entries/"

    private val RetrofitInstance by lazy{
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        RetrofitInstance?.create(ApiInterface::class.java)
    }
}