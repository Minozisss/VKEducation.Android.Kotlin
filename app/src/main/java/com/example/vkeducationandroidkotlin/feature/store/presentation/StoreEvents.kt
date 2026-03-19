package com.example.vkeducationandroidkotlin.feature.store.presentation

sealed interface StoreEvents {
    data class ShowSnackbar(
        val message: String
    ) : StoreEvents
}