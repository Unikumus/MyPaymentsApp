package com.unikumus.mypayments.ui.fragments.payments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unikumus.mypayments.models.Payments
import com.unikumus.mypayments.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PaymentsViewModel(private val repository: Repository):ViewModel() {

    val myResponse: MutableLiveData<Response<Payments>> = MutableLiveData()

    fun getPayments(token:String?){
        viewModelScope.launch {
            val response:Response<Payments> = repository.getPayments(token)
            myResponse.value = response

        }
    }


}