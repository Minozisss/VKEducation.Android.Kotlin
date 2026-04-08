package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetail
import javax.inject.Inject

class AppDetailMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun toDomain(dto: AppDetailDto): AppDetail = AppDetail(
        id = dto.id,
        name = dto.name,
        slogan = dto.slogan,
        developer = dto.developer,
        category = categoryMapper.mapToDomain(dto.category),
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        description = dto.description
    )
}