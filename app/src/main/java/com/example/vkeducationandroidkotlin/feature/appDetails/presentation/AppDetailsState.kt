package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetail

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val appDetail: AppDetail
    ) : AppDetailsState
}