package com.unikumus.mypayments.repository

import com.unikumus.mypayments.models.Login
import com.unikumus.mypayments.models.LoginPostData
import com.unikumus.mypayments.models.Payments
import com.unikumus.mypayments.servises.api.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun login(loginPostData: LoginPostData): Response<Login> {
        return RetrofitInstance.api.login(loginPostData)
    }

    suspend fun getPayments(token:String?): Response<Payments> {
       return RetrofitInstance.api.getMyPayments(token)
    }
}