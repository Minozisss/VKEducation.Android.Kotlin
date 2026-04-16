package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailsRepository
import javax.inject.Inject

//Сделаем пока что моковый Repository
class AppDetailsRepositoryImplMock @Inject constructor(
    private val api: AppDetailsApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val appDto = api.get(id)
        val app = mapper.toDomain(appDto)
        return app
    }
}