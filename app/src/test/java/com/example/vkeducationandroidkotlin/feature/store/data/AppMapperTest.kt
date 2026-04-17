package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.core.domain.Category
import org.junit.Assert.assertEquals
import org.junit.Test

class AppMapperTest {

    private val mapper = AppMapper(CategoryMapper())

    @Test
    fun `toDomain maps dto fields to app`() {
        val dto = AppDto(
            id = "app-1",
            name = "BudgetApp",
            description = "Track your spending",
            category = "Finance",
            iconUrl = "https://example.com/icon.png"
        )

        val result = mapper.toDomain(dto)

        assertEquals("app-1", result.id)
        assertEquals("BudgetApp", result.name)
        assertEquals("Track your spending", result.slogan)
        assertEquals(Category.FINANCE, result.category)
        assertEquals("https://example.com/icon.png", result.iconUrl)
    }

    @Test
    fun `toDomain maps unknown category to OTHER`() {
        val dto = AppDto(
            id = "app-2",
            name = "MysteryApp",
            description = "Unknown category",
            category = "Unknown",
            iconUrl = "https://example.com/unknown.png"
        )

        val result = mapper.toDomain(dto)

        assertEquals(Category.OTHER, result.category)
    }
}
