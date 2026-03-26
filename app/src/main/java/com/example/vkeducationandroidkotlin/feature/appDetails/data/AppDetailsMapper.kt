package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = categoryMapper.mapToDomain(dto.category),
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshots,
        description = dto.description
    )
}