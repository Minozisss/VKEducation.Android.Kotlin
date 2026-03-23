package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.feature.store.domain.App
import javax.inject.Inject

class AppMapper @Inject constructor(
    private val categoryMapper: CategoryMapper
) {
    fun toDomain(appDto: AppDto): App = App(
        id = appDto.id,
        name = appDto.name,
        slogan = appDto.slogan,
        category = categoryMapper.mapToDomain(appDto.category),
        iconUrl = appDto.iconUrl
    )
}