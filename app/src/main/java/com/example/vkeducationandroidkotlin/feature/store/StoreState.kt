package com.example.vkeducationandroidkotlin.feature.store

import com.example.vkeducationandroidkotlin.domain.App

sealed interface StoreState {
    data object Loading : StoreState
    data object Error : StoreState
    data class Content(val apps: List<App>) : StoreState
}