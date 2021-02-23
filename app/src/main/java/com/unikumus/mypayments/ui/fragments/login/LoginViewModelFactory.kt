package com.unikumus.mypayments.ui.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unikumus.mypayments.repository.Repository
import com.unikumus.mypayments.ui.fragments.payments.PaymentsViewModel

class LoginViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}