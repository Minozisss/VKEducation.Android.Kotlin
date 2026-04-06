package com.example.vkeducationandroidkotlin.feature.appDetails.data

data class AppDetailDto(
    val id: String,
    val name: String,
    val slogan: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String
)
