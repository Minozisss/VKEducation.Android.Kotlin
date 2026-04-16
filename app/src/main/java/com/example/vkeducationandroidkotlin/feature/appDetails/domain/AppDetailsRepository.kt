package com.example.vkeducationandroidkotlin.feature.appDetails.domain

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}