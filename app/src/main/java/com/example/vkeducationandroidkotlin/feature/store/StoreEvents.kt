package com.example.vkeducationandroidkotlin.feature.store

sealed interface StoreEvents {
    data class ShowSnackbar(
        val message: String
    ) : StoreEvents
}