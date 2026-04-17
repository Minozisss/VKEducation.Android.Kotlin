package com.example.vkeducationandroidkotlin.feature.store.data

import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.store.domain.App
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AppRepositoryImplTest {

    private val api = mockk<AppApi>()
    private val mapper = mockk<AppMapper>()

    private val repository = AppRepositoryImpl(
        appApi = api,
        mapper = mapper
    )

    @Test
    fun `getApps returns mapped domain list`() = runTest {
        val firstDto = AppDto("1", "Budget", "Track expenses", "Finance", "icon-1")
        val secondDto = AppDto("2", "Roads", "Move around", "Transportation", "icon-2")
        val firstApp = App("1", "Budget", "Track expenses", Category.FINANCE, "icon-1")
        val secondApp = App("2", "Roads", "Move around", Category.TRANSPORTATION, "icon-2")

        coEvery { api.get() } returns listOf(firstDto, secondDto)
        every { mapper.toDomain(firstDto) } returns firstApp
        every { mapper.toDomain(secondDto) } returns secondApp

        val result = repository.getApps()

        assertEquals(listOf(firstApp, secondApp), result)
    }

    @Test
    fun `getApps calls api once and maps each dto`() = runTest {
        val dto = AppDto("1", "Budget", "Track expenses", "Finance", "icon-1")
        val app = App("1", "Budget", "Track expenses", Category.FINANCE, "icon-1")

        coEvery { api.get() } returns listOf(dto)
        every { mapper.toDomain(dto) } returns app

        repository.getApps()

        coVerify(exactly = 1) { api.get() }
        verify(exactly = 1) { mapper.toDomain(dto) }
    }
}
