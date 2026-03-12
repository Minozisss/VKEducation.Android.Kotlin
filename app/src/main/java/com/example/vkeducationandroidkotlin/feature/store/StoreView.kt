package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val StoreListTopCornerRadius = 24.dp

@Composable
fun StoreView(
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Toolbar(
            someToolbarButtonAction = { }
        )

        AppsScroll(
            modifier = Modifier
                .background(color = Color.Blue)
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

private fun getApps(): List<AppItem> = listOf(
    AppItem(
        icon = Icons.Default.Home,
        title = "Сбербанк Онлайн - с Салютом",
        slogan = "Больше чем банк",
        category = "Финансы"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс Браузер",
        slogan = "Быстрый и безопасный браузер",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Почта Mail.ru",
        slogan = "Почтовый клиент для любых ящиков",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс Навигатор",
        slogan = "Парковки и заправки - по пути",
        category = "Транспорт"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Мой МТС",
        slogan = "Мой МТС - центр экосистемы МТС",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс - с Алисой",
        slogan = "Яндекс - поиск всегда под рукой",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Сбербанк Онлайн - с Салютом",
        slogan = "Больше чем банк",
        category = "Финансы"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс Браузер",
        slogan = "Быстрый и безопасный браузер",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Почта Mail.ru",
        slogan = "Почтовый клиент для любых ящиков",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс Навигатор",
        slogan = "Парковки и заправки - по пути",
        category = "Транспорт"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Мой МТС",
        slogan = "Мой МТС - центр экосистемы МТС",
        category = "Инструменты"
    ),
    AppItem(
        icon = Icons.Default.Home,
        title = "Яндекс - с Алисой",
        slogan = "Яндекс - поиск всегда под рукой",
        category = "Инструменты"
    )
)

@Preview
@Composable
private fun Preview() {
    StoreView()
}
