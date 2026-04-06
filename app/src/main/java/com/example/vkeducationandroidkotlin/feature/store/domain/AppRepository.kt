package com.example.vkeducationandroidkotlin.feature.store.domain

interface AppRepository {
    suspend fun get(): List<App>
}