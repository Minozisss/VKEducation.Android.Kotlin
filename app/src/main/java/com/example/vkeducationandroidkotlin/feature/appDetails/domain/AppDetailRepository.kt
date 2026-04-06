package com.example.vkeducationandroidkotlin.feature.appDetails.domain

interface AppDetailRepository {
    suspend fun get(id: String): AppDetail
}