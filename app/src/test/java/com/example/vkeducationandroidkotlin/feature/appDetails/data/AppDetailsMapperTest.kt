package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.core.domain.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class AppDetailsMapperTest {

    private val mapper = AppDetailsMapper(CategoryMapper())

    @Test
    fun `toDomain maps dto fields to app details`() {
        val dto = AppDetailsDto(
            id = "details-1",
            name = "TaskLoop",
            developer = "Loopware",
            category = "Tools",
            ageRating = 12,
            size = 55.5,
            iconUrl = "https://example.com/taskloop.png",
            screenshots = listOf("shot-1", "shot-2"),
            description = "Organize tasks"
        )

        val result = mapper.toDomain(dto)

        assertEquals("details-1", result.id)
        assertEquals("TaskLoop", result.name)
        assertEquals("Loopware", result.developer)
        assertEquals(Category.TOOLS, result.category)
        assertEquals(12, result.ageRating)
        assertEquals(55.5, result.size, 0.0)
        assertEquals("https://example.com/taskloop.png", result.iconUrl)
        assertEquals(listOf("shot-1", "shot-2"), result.screenshotUrlList)
        assertEquals("Organize tasks", result.description)
    }

    @Test
    fun `toDomain uses default wishlist value`() {
        val dto = AppDetailsDto(
            id = "details-2",
            name = "MoneyFlow",
            developer = "FinTech",
            category = "Finance",
            ageRating = 3,
            size = 10.0,
            iconUrl = "https://example.com/moneyflow.png",
            screenshots = emptyList(),
            description = "Finance app"
        )

        val result = mapper.toDomain(dto)

        assertFalse(result.isInWishList)
    }
}
