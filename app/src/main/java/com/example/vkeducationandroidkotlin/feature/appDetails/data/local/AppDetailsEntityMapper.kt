package com.example.vkeducationandroidkotlin.feature.appDetails.data.local

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailsDto
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import javax.inject.Inject

class AppDetailsEntityMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {

    fun toEntity(domain: AppDetails): AppDetailsEntity = AppDetailsEntity(
        id = domain.id,
        name = domain.name,
        developer = domain.developer,
        category = domain.category.name,
        ageRating = domain.ageRating,
        size = domain.size,
        iconUrl = domain.iconUrl,
        screenshotUrlList = domain.screenshotUrlList,
        description = domain.description,
        isInWishList = domain.isInWishList
    )

    fun toEntity(dto: AppDetailsDto): AppDetailsEntity = AppDetailsEntity(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshots,
        description = dto.description
    )

    fun toDomain(entity: AppDetailsEntity): AppDetails = AppDetails(
        id = entity.id,
        name = entity.name,
        developer = entity.developer,
        category = categoryMapper.mapToDomain(entity.category),
        ageRating = entity.ageRating,
        size = entity.size,
        iconUrl = entity.iconUrl,
        screenshotUrlList = entity.screenshotUrlList,
        description = entity.description,
        isInWishList = entity.isInWishList
    )
}
