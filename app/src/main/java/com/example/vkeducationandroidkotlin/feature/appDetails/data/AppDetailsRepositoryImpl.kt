package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsDao
import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsEntityMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailsRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
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

    override suspend fun toggleWishList(id: String) {
        val currentEntity = appDetailsDao.getAppDetails(id).first()

        currentEntity?.let {
            appDetailsDao.updateWishListStatus(id, !it.isInWishList)
        }
    }

    override fun observeAppDetails(id: String): Flow<AppDetails> {
        return appDetailsDao.getAppDetails(id)
            .filterNotNull()
            .map { entityMapper.toDomain(it) }
    }
}
