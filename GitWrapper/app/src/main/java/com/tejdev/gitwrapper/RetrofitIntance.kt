package com.tejdev.gitwrapper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIntance {
    private const val BASE_URL = "https://meme-api.com/"
//        "https://api.github.com"

    private val RetrofitInstance by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiInterface by lazy {
        RetrofitInstance.create(ApiInterface::class.java)
    }
}