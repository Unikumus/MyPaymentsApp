package com.unikumus.mypayments.models

data class Response(
    val amount: Any,
    val created: Int,
    val currency: String,
    val desc: String
)