package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsDao
import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsEntity
import com.example.vkeducationandroidkotlin.feature.appDetails.data.local.AppDetailsEntityMapper
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailsRepositoryImplTest {

    private val api = mockk<AppDetailsApi>()
    private val dao = mockk<AppDetailsDao>()
    private val entityMapper = mockk<AppDetailsEntityMapper>()

    private val repository = AppDetailsRepositoryImpl(
        appDetailApi = api,
        appDetailsDao = dao,
        entityMapper = entityMapper
    )

    @Test
    fun `getAppDetails returns data from dao when entity exists`() = runTest {
        val entity = sampleEntity(isInWishList = true)
        val domain = sampleDomain(isInWishList = true)

        every { dao.getAppDetails("details-1") } returns flowOf(entity)
        every { entityMapper.toDomain(entity) } returns domain

        val result = repository.getAppDetails("details-1")

        assertEquals(domain, result)
        coVerify(exactly = 0) { api.get(any()) }
        coVerify(exactly = 0) { dao.insertAppDetails(any()) }
    }

    @Test
    fun `getAppDetails requests api when dao is empty`() = runTest {
        val dto = sampleDto()
        val entity = sampleEntity()
        val domain = sampleDomain()

        every { dao.getAppDetails("details-1") } returns flowOf(null)
        coEvery { api.get("details-1") } returns dto
        every { entityMapper.toEntity(dto) } returns entity
        every { entityMapper.toDomain(entity) } returns domain
        coEvery { dao.insertAppDetails(entity) } returns Unit

        val result = repository.getAppDetails("details-1")

        assertEquals(domain, result)
        coVerify(exactly = 1) { api.get("details-1") }
    }

    @Test
    fun `getAppDetails saves mapped entity to dao after api response`() = runTest {
        val dto = sampleDto()
        val entity = sampleEntity()
        val domain = sampleDomain()

        every { dao.getAppDetails("details-1") } returns flowOf(null)
        coEvery { api.get("details-1") } returns dto
        every { entityMapper.toEntity(dto) } returns entity
        every { entityMapper.toDomain(entity) } returns domain
        coEvery { dao.insertAppDetails(entity) } returns Unit

        repository.getAppDetails("details-1")

        coVerify(exactly = 1) { dao.insertAppDetails(entity) }
    }

    @Test
    fun `toggleWishList updates dao with inverted status when entity exists`() = runTest {
        val entity = sampleEntity(isInWishList = false)

        every { dao.getAppDetails("details-1") } returns flowOf(entity)
        coEvery { dao.updateWishListStatus("details-1", true) } returns Unit

        repository.toggleWishList("details-1")

        coVerify(exactly = 1) { dao.updateWishListStatus("details-1", true) }
    }

    @Test
    fun `toggleWishList does not update dao when entity is missing`() = runTest {
        every { dao.getAppDetails("details-1") } returns flowOf(null)

        repository.toggleWishList("details-1")

        coVerify(exactly = 0) { dao.updateWishListStatus(any(), any()) }
    }

    @Test
    fun `observeAppDetails maps dao entity flow to domain flow`() = runTest {
        val entity = sampleEntity(isInWishList = true)
        val domain = sampleDomain(isInWishList = true)

        every { dao.getAppDetails("details-1") } returns flowOf(entity)
        every { entityMapper.toDomain(entity) } returns domain

        val result = repository.observeAppDetails("details-1").first()

        assertEquals(domain, result)
        verify(exactly = 1) { entityMapper.toDomain(entity) }
    }

    private fun sampleDto() = AppDetailsDto(
        id = "details-1",
        name = "TaskLoop",
        developer = "Loopware",
        category = "Tools",
        ageRating = 12,
        size = 20.5,
        iconUrl = "https://example.com/taskloop.png",
        screenshots = listOf("shot-1", "shot-2"),
        description = "Task planner"
    )

    private fun sampleEntity(isInWishList: Boolean = false) = AppDetailsEntity(
        id = "details-1",
        name = "TaskLoop",
        developer = "Loopware",
        category = "Tools",
        ageRating = 12,
        size = 20.5,
        iconUrl = "https://example.com/taskloop.png",
        screenshotUrlList = listOf("shot-1", "shot-2"),
        description = "Task planner",
        isInWishList = isInWishList
    )

    private fun sampleDomain(isInWishList: Boolean = false) = AppDetails(
        id = "details-1",
        name = "TaskLoop",
        developer = "Loopware",
        category = Category.TOOLS,
        ageRating = 12,
        size = 20.5,
        iconUrl = "https://example.com/taskloop.png",
        screenshotUrlList = listOf("shot-1", "shot-2"),
        description = "Task planner",
        isInWishList = isInWishList
    )
}
