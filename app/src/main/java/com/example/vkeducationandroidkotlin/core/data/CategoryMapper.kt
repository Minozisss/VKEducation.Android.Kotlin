package com.example.vkeducationandroidkotlin.core.data

import com.example.vkeducationandroidkotlin.core.domain.Category

class CategoryMapper {
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