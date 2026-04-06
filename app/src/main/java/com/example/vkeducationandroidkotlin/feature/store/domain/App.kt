package com.example.vkeducationandroidkotlin.feature.store.domain

import com.example.vkeducationandroidkotlin.core.domain.Category

data class App(
    val id: String,
    val name: String,
    val slogan: String,
    val category: Category,
    val iconUrl: String
)
