package com.example.vkeducationandroidkotlin.feature.store.domain

interface AppRepository {
    suspend fun getApps(): List<App>
}