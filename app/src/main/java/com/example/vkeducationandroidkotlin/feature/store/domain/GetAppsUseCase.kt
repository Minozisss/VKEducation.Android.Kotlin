package com.example.vkeducationandroidkotlin.feature.store.domain

import javax.inject.Inject

class GetAppsUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): List<App> {
        val apps: List<App> = repository.getApps()
        return apps
    }
}