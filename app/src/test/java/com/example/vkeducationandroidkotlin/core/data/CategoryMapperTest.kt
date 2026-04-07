package com.example.vkeducationandroidkotlin.core.data

import com.example.vkeducationandroidkotlin.core.domain.Category
import org.junit.Assert.assertEquals
import org.junit.Test

class CategoryMapperTest {

    private val mapper = CategoryMapper()

    @Test
    fun `mapToDomain maps App to APP`() {
        assertEquals(Category.APP, mapper.mapToDomain("App"))
    }

    @Test
    fun `mapToDomain maps Game to GAME`() {
        assertEquals(Category.GAME, mapper.mapToDomain("Game"))
    }

    @Test
    fun `mapToDomain maps Finance to FINANCE`() {
        assertEquals(Category.FINANCE, mapper.mapToDomain("Finance"))
    }

    @Test
    fun `mapToDomain maps Tools to TOOLS`() {
        assertEquals(Category.TOOLS, mapper.mapToDomain("Tools"))
    }

    @Test
    fun `mapToDomain maps Transportation to TRANSPORTATION`() {
        assertEquals(Category.TRANSPORTATION, mapper.mapToDomain("Transportation"))
    }

    @Test
    fun `mapToDomain maps unknown category to OTHER`() {
        assertEquals(Category.OTHER, mapper.mapToDomain("Unknown"))
    }
}
