package com.example.vkeducationandroidkotlin.feature.appDetails

import com.example.vkeducationandroidkotlin.domain.App

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val app: App
    ) : AppDetailsState
}