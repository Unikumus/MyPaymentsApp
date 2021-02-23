package com.unikumus.mypayments.models

import com.google.gson.annotations.SerializedName

data class LoginPostData(
    @SerializedName("login") var login: String,
    @SerializedName("password") var password: String
)