package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import com.example.vkeducationandroidkotlin.core.domain.Category

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
    val isInWishList: Boolean = false
)