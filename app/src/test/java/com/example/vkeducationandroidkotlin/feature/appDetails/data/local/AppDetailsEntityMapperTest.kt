package com.example.vkeducationandroidkotlin.feature.appDetails.data.local

import com.example.vkeducationandroidkotlin.core.data.CategoryMapper
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailsDto
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppDetailsEntityMapperTest {

    private val mapper = AppDetailsEntityMapper(CategoryMapper())

    @Test
    fun `toEntity maps domain fields to entity`() {
        val domain = AppDetails(
            id = "details-3",
            name = "RoadMap",
            developer = "MoveSoft",
            category = Category.TRANSPORTATION,
            ageRating = 7,
            size = 22.4,
            iconUrl = "https://example.com/roadmap.png",
            screenshotUrlList = listOf("shot-a", "shot-b"),
            description = "Transport app",
            isInWishList = true
        )

        val result = mapper.toEntity(domain)

        assertEquals("details-3", result.id)
        assertEquals("RoadMap", result.name)
        assertEquals("MoveSoft", result.developer)
        assertEquals("TRANSPORTATION", result.category)
        assertEquals(7, result.ageRating)
        assertEquals(22.4, result.size, 0.0)
        assertEquals("https://example.com/roadmap.png", result.iconUrl)
        assertEquals(listOf("shot-a", "shot-b"), result.screenshotUrlList)
        assertEquals("Transport app", result.description)
        assertTrue(result.isInWishList)
    }

    @Test
    fun `toEntity maps dto fields to entity with default wishlist value`() {
        val dto = AppDetailsDto(
            id = "details-4",
            name = "PocketBank",
            developer = "BankLab",
            category = "Finance",
            ageRating = 16,
            size = 99.9,
            iconUrl = "https://example.com/pocketbank.png",
            screenshots = listOf("screen-1"),
            description = "Banking app"
        )

        val result = mapper.toEntity(dto)

        assertEquals("details-4", result.id)
        assertEquals("PocketBank", result.name)
        assertEquals("BankLab", result.developer)
        assertEquals("Finance", result.category)
        assertEquals(16, result.ageRating)
        assertEquals(99.9, result.size, 0.0)
        assertEquals("https://example.com/pocketbank.png", result.iconUrl)
        assertEquals(listOf("screen-1"), result.screenshotUrlList)
        assertEquals("Banking app", result.description)
        assertFalse(result.isInWishList)
    }

    @Test
    fun `toDomain maps entity fields to domain`() {
        val entity = AppDetailsEntity(
            id = "details-5",
            name = "SafeVault",
            developer = "Protect Inc",
            category = "App",
            ageRating = 18,
            size = 30.0,
            iconUrl = "https://example.com/safevault.png",
            screenshotUrlList = listOf("image-1", "image-2"),
            description = "Secure storage",
            isInWishList = true
        )

        val result = mapper.toDomain(entity)

        assertEquals("details-5", result.id)
        assertEquals("SafeVault", result.name)
        assertEquals("Protect Inc", result.developer)
        assertEquals(Category.APP, result.category)
        assertEquals(18, result.ageRating)
        assertEquals(30.0, result.size, 0.0)
        assertEquals("https://example.com/safevault.png", result.iconUrl)
        assertEquals(listOf("image-1", "image-2"), result.screenshotUrlList)
        assertEquals("Secure storage", result.description)
        assertTrue(result.isInWishList)
    }
}
