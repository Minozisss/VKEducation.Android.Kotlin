package com.example.vkeducationandroidkotlin.feature.appDetails.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ToggleWishListUseCaseTest {

    private val repository = mockk<AppDetailsRepository>()
    private val useCase = ToggleWishListUseCase(repository)

    @Test
    fun `invoke calls repository toggleWishList once`() = runTest {
        coEvery { repository.toggleWishList("details-5") } returns Unit

        useCase("details-5")

        coVerify(exactly = 1) { repository.toggleWishList("details-5") }
    }
}
