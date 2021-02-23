package com.unikumus.mypayments.ui.fragments.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unikumus.mypayments.repository.Repository

class PaymentsViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentsViewModel(repository) as T
    }
}