package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import com.example.vkeducationandroidkotlin.core.domain.Category

data class AppDetail(
    val id: String,
    val name: String,
    val slogan: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String
)