package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import com.example.vkeducationandroidkotlin.core.domain.Category
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ObserveAppDetailsUseCaseTest {

    private val repository = mockk<AppDetailsRepository>()
    private val useCase = ObserveAppDetailsUseCase(repository)

    @Test
    fun `invoke returns repository flow values`() = runTest {
        val appDetails = AppDetails(
            id = "details-3",
            name = "MoneyFlow",
            developer = "BankLab",
            category = Category.FINANCE,
            ageRating = 16,
            size = 44.0,
            iconUrl = "https://example.com/moneyflow.png",
            screenshotUrlList = listOf("shot-1"),
            description = "Finance app"
        )
        every { repository.observeAppDetails("details-3") } returns flowOf(appDetails)

        val result = useCase("details-3").first()

        assertEquals(appDetails, result)
    }

    @Test
    fun `invoke calls repository observeAppDetails once`() {
        every { repository.observeAppDetails("details-4") } returns flowOf(sampleAppDetails("details-4"))

        useCase("details-4")

        verify(exactly = 1) { repository.observeAppDetails("details-4") }
    }

    private fun sampleAppDetails(id: String) = AppDetails(
        id = id,
        name = "Sample",
        developer = "Developer",
        category = Category.APP,
        ageRating = 3,
        size = 10.0,
        iconUrl = "https://example.com/icon.png",
        screenshotUrlList = emptyList(),
        description = "Description"
    )
}
