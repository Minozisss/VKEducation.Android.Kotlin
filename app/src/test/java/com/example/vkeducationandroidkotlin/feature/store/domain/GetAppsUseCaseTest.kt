package com.example.vkeducationandroidkotlin.feature.store.domain

import com.example.vkeducationandroidkotlin.core.domain.Category
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppsUseCaseTest {

    private val repository = mockk<AppRepository>()
    private val useCase = GetAppsUseCase(repository)

    @Test
    fun `invoke returns apps from repository`() = runTest {
        val apps = listOf(
            App(
                id = "1",
                name = "Budget",
                slogan = "Track expenses",
                category = Category.FINANCE,
                iconUrl = "https://example.com/budget.png"
            ),
            App(
                id = "2",
                name = "Roads",
                slogan = "Move around the city",
                category = Category.TRANSPORTATION,
                iconUrl = "https://example.com/roads.png"
            )
        )
        coEvery { repository.getApps() } returns apps

        val result = useCase()

        assertEquals(apps, result)
    }

    @Test
    fun `invoke calls repository getApps once`() = runTest {
        coEvery { repository.getApps() } returns emptyList()

        useCase()

        coVerify(exactly = 1) { repository.getApps() }
    }
}
