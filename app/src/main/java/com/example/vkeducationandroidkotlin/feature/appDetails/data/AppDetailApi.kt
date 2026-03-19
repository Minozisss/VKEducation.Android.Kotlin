package com.example.vkeducationandroidkotlin.feature.appDetails.data

// Фейковый backend
class AppDetailApi {
    suspend fun get(id: String): AppDetailDto {
        return appDetails.first { it.id == id }
    }

    // Пока что тут захардкоженные данные
    private val appDetails: List<AppDetailDto> = listOf(
        AppDetailDto(
            id = "1",
            name = "Сбербанк Онлайн - с Салютом",
            slogan = "Больше чем банк",
            developer = "Сбербанк",
            category = "Finance",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        AppDetailDto(
            id = "2",
            name = "Яндекс Браузер",
            slogan = "Быстрый и безопасный браузер",
            developer = "Яндекс",
            category = "Tools",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        AppDetailDto(
            id = "3",
            name = "Почта Mail.ru",
            slogan = "Почтовый клиент для любых ящико",
            developer = "Mail",
            category = "Tools",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        AppDetailDto(
            id = "4",
            name = "Яндекс Навигатор",
            slogan = "Парковки и заправки - по пути",
            developer = "Яндекс",
            category = "Transportation",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        AppDetailDto(
            id = "5",
            name = "Мой МТС",
            slogan = "Мой МТС - центр экосистемы МТС",
            developer = "МТС",
            category = "Tools",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        AppDetailDto(
            id = "6",
            name = "Яндекс - с Алисой",
            slogan = "Яндекс - поиск всегда под рукой",
            developer = "Яндекс",
            category = "Tools",
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        )
    )
}