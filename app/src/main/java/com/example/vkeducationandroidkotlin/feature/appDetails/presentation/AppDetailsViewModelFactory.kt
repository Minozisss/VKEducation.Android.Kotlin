package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppDetailsViewModelFactory(
    private val id: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == AppDetailsViewModel::class.java) {
            return AppDetailsViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}