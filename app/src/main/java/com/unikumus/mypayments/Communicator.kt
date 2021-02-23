package com.unikumus.mypayments

import com.unikumus.mypayments.models.Login

interface Communicator {
    fun passDataCom(token: String)
}