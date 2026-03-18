package com.example.vkeducationandroidkotlin.feature.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeducationandroidkotlin.domain.App
import com.example.vkeducationandroidkotlin.domain.Category
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoreViewModel : ViewModel() {
    private val _state: MutableStateFlow<StoreState> = MutableStateFlow(
        StoreState.Loading
    )
    val state: StateFlow<StoreState> = _state.asStateFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            runCatching {
                _state.value = StoreState.Loading

                delay(1000L) // Условный сценарий загрузки. Было в лекции

                val apps: List<App> = getApps()

                _state.value = StoreState.Content(apps)
            }.onFailure {
                _state.value = StoreState.Error
            }
        }
    }

    private fun getApps(): List<App> = listOf(
        App(
            name = "Сбербанк Онлайн - с Салютом",
            slogan = "Больше чем банк",
            developer = "Сбербанк",
            category = Category.FINANCE,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        App(
            name = "Яндекс Браузер",
            slogan = "Быстрый и безопасный браузер",
            developer = "Яндекс",
            category = Category.TOOLS,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        App(
            name = "Почта Mail.ru",
            slogan = "Почтовый клиент для любых ящико",
            developer = "Mail",
            category = Category.TOOLS,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        App(
            name = "Яндекс Навигатор",
            slogan = "Парковки и заправки - по пути",
            developer = "Яндекс",
            category = Category.TRANSPORTATION,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        App(
            name = "Мой МТС",
            slogan = "Мой МТС - центр экосистемы МТС",
            developer = "Mail",
            category = Category.TOOLS,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        ),
        App(
            name = "Яндекс - с Алисой",
            slogan = "Яндекс - поиск всегда под рукойи",
            developer = "Яндекс",
            category = Category.TOOLS,
            ageRating = 18,
            size = 130.0f,
            iconUrl = "",
            screenshotUrlList = listOf(),
            description = "Description"
        )
    )
}