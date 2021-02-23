package com.unikumus.mypayments.servises.api

import com.unikumus.mypayments.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiRequests by lazy{
        retrofit.create(ApiRequests::class.java)
    }
}