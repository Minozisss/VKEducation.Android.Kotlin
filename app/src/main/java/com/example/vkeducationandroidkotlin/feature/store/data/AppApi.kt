package com.example.vkeducationandroidkotlin.feature.store.data

import javax.inject.Inject

class AppApi @Inject constructor() {
    suspend fun get(): List<AppDto> {
        val apps: List<AppDto> = listOf(
            AppDto(
                id = "1",
                name = "Сбербанк Онлайн - с Салютом",
                slogan = "Больше чем банк",
                category = "Finance",
                iconUrl = ""
            ),
            AppDto(
                id = "2",
                name = "Яндекс Браузер",
                slogan = "Быстрый и безопасный браузер",
                category = "Tools",
                iconUrl = ""
            ),
            AppDto(
                id = "3",
                name = "Почта Mail.ru",
                slogan = "Почтовый клиент для любых ящико",
                category = "Tools",
                iconUrl = ""
            ),
            AppDto(
                id = "4",
                name = "Яндекс Навигатор",
                slogan = "Парковки и заправки - по пути",
                category = "Transportation",
                iconUrl = ""
            ),
            AppDto(
                id = "5",
                name = "Мой МТС",
                slogan = "Мой МТС - центр экосистемы МТС",
                category = "Tools",
                iconUrl = ""
            ),
            AppDto(
                id = "6",
                name = "Яндекс - с Алисой",
                slogan = "Яндекс - поиск всегда под рукойи",
                category = "Tools",
                iconUrl = ""
            )
        )

        return apps
    }
}