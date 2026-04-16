package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsDao
import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsEntityMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailsRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class AppDetailsRepositoryImpl @Inject constructor(
    private val appDetailApi: AppDetailsApi,
    private val appDetailsDao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val entity = appDetailsDao.getAppDetails(id).first()

        return if (entity != null) {
            entityMapper.toDomain(entity)
        } else {
            val dto = appDetailApi.get(id)
            val appDetailsEntity = entityMapper.toEntity(dto)

            withContext(Dispatchers.IO) {
                appDetailsDao.insertAppDetails(appDetailsEntity)
            }

            entityMapper.toDomain(appDetailsEntity)
        }
    }
}
