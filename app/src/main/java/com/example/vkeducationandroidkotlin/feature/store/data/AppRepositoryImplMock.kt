package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository

class AppRepositoryImplMock(
    private val api: AppApi,
    private val mapper: AppMapper
) : AppRepository {
    override suspend fun get(): List<App> {
        val dtoApps: List<AppDto> = api.get()
        val apps: List<App> = dtoApps.map { mapper.toDomain(it) }
        return apps
    }
}