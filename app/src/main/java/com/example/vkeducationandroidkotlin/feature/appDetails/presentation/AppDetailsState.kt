package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val appDetails: AppDetails
    ) : AppDetailsState
}
