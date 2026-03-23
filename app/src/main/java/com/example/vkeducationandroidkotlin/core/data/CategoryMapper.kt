package com.example.vkeducationandroidkotlin.core.data

import com.example.vkeducationandroidkotlin.core.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun mapToDomain(category: String): Category {
        return when (category) {
            "App" -> Category.APP
            "Game" -> Category.GAME
            "Finance" -> Category.FINANCE
            "Tools" -> Category.TOOLS
            "Transportation" -> Category.TRANSPORTATION
            else -> Category.OTHER
        }
    }
}