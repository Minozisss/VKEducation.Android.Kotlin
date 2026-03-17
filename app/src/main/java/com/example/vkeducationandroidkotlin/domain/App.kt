package com.example.vkeducationandroidkotlin.domain

data class App(
    val name: String,
    val slogan: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)