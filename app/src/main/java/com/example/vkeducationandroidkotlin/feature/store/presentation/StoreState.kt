package com.example.vkeducationandroidkotlin.feature.store.presentation

import com.example.vkeducationandroidkotlin.feature.store.domain.App

sealed interface StoreState {
    data object Loading : StoreState
    data object Error : StoreState
    data class Content(val apps: List<App>) : StoreState
}