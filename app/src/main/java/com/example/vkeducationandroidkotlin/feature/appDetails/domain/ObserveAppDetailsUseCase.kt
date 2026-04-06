package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveAppDetailsUseCase @Inject constructor(
    private val repository : AppDetailsRepository
) {
    operator fun invoke(id: String): Flow<AppDetails> {
        return repository.observeAppDetails(id)
    }
}