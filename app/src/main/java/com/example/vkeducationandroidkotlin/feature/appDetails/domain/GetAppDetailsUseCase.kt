package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String): AppDetails {
        val appDetails = repository.getAppDetails(id)
        return appDetails
    }
}