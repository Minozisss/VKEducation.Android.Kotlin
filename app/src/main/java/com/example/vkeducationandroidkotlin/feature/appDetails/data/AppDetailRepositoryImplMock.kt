package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetail
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailRepository
import javax.inject.Inject

//Сделаем пока что моковый Repository
class AppDetailRepositoryImplMock @Inject constructor(
    private val api: AppDetailApi,
    private val mapper: AppDetailMapper
) : AppDetailRepository {
    override suspend fun get(id: String): AppDetail {
        val appDto = api.get(id)
        val app = mapper.toDomain(appDto)
        return app
    }
}