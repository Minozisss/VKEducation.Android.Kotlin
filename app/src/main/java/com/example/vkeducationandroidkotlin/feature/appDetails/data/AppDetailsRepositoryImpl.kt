package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appDetailApi: AppDetailsApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = appDetailApi.get(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}