package com.unikumus.mypayments.ui.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unikumus.mypayments.models.Login
import com.unikumus.mypayments.models.LoginPostData
import com.unikumus.mypayments.models.Payments
import com.unikumus.mypayments.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Login>> = MutableLiveData()

    fun login(loginPostData: LoginPostData){
        viewModelScope.launch {
            val response: Response<Login> = repository.login(loginPostData)
            myResponse.value = response

        }
    }


}