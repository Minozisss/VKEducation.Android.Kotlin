package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor() : AppRepository {
    override suspend fun get(): List<App> {
        TODO("В дальнейшем реализовать бекенд")
    }

}