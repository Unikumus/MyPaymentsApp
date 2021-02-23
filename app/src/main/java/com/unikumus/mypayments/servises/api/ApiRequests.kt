package com.unikumus.mypayments.servises.api

import com.unikumus.mypayments.models.Login
import com.unikumus.mypayments.models.LoginPostData
import com.unikumus.mypayments.models.Payments
import retrofit2.Response
import retrofit2.http.*

interface ApiRequests {

    @GET("api/payments")
    @Headers("app-key: 12345", "v: 1")
    suspend fun getMyPayments(
        @Query("token") TOKEN: String?,
    ): Response<Payments>

    @POST("api/login")
    @Headers("app-key: 12345", "v: 1")
    suspend fun login(
        @Body LoginPostData: LoginPostData,
    ): Response<Login>

}

