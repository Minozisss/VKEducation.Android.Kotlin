package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.ui.graphics.vector.ImageVector

data class AppItem(
    val icon: ImageVector,
    val title: String,
    val slogan: String,
    val category: String
)