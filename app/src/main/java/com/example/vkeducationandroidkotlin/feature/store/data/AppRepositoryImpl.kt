package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: AppMapper
) : AppRepository {
    override suspend fun getApps(): List<App> {
        val dto = appApi.get()
        val domain = dto.map { mapper.toDomain(it) }
        return domain
    }

}