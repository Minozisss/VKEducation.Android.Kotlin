package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository

class AppRepositoryImpl : AppRepository {
    override suspend fun get(): List<App> {
        TODO("В дальнейшем реализовать бекенд")
    }

}