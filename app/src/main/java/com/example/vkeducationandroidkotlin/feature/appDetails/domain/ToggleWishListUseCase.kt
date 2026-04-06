package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import javax.inject.Inject

class ToggleWishListUseCase @Inject constructor(
    private val repository: AppDetailsRepository
)  {
    suspend operator fun invoke (id: String) {
        repository.toggleWishList(id)
    }
}