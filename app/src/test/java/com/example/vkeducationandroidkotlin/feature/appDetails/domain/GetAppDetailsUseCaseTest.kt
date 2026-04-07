package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import com.example.vkeducationandroidkotlin.core.domain.Category
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppDetailsUseCaseTest {

    private val repository = mockk<AppDetailsRepository>()
    private val useCase = GetAppDetailsUseCase(repository)

    @Test
    fun `invoke returns app details from repository`() = runTest {
        val appDetails = AppDetails(
            id = "details-1",
            name = "TaskLoop",
            developer = "Loopware",
            category = Category.TOOLS,
            ageRating = 12,
            size = 20.5,
            iconUrl = "https://example.com/taskloop.png",
            screenshotUrlList = listOf("1", "2"),
            description = "Task planner",
            isInWishList = true
        )
        coEvery { repository.getAppDetails("details-1") } returns appDetails

        val result = useCase("details-1")

        assertEquals(appDetails, result)
    }

    @Test
    fun `invoke passes id to repository`() = runTest {
        coEvery { repository.getAppDetails("details-2") } returns sampleAppDetails(id = "details-2")

        useCase("details-2")

        coVerify(exactly = 1) { repository.getAppDetails("details-2") }
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
