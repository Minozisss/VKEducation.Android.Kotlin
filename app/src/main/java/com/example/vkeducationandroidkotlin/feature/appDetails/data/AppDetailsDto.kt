package com.example.vkeducationandroidkotlin.feature.appDetails.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    @SerialName("screenshotUrlList")
    val screenshots: List<String>,
    val description: String
)
