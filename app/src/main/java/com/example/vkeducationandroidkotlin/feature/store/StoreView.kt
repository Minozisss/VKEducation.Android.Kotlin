package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.domain.App
import com.example.vkeducationandroidkotlin.domain.Category
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

private val StoreListTopCornerRadius = 24.dp

@Composable
fun StoreView(
    modifier: Modifier = Modifier,
    onAppClick: (App) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Toolbar(
            onClickToolbarButton = { } // правда не знаю, что она делает :)
        )

        AppList(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .clip(
                    RoundedCornerShape(
                        topStart = StoreListTopCornerRadius,
                        topEnd = StoreListTopCornerRadius
                    )
                ),
            items = getApps(),
            onAppClick = onAppClick
        )
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

@Preview
@Composable
private fun Preview() {
    VKEducationAndroidKotlinTheme() {
        StoreView() {}
    }
}
