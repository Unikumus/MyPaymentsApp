package com.unikumus.mypayments.models

data class Payments(
    val response: List<Response>,
    val success: String
)