package com.example.vkeducationandroidkotlin.feature.store.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

val StoreListTopCornerRadius = 24.dp

@Composable
fun StoreContent(
    modifier: Modifier = Modifier,
    apps: List<App>,
    onClickToolbarLogo: () -> Unit,
    onAppClick: (id: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Toolbar(
            onClickToolbarLogo = onClickToolbarLogo,
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
            items = apps,
            onAppClick = onAppClick
        )
    }
}

@Preview
@Composable
private fun Preview() {
    val apps: List<App> = listOf(
        App(
            id = "1",
            name = "Сбербанк Онлайн - с Салютом",
            slogan = "Больше чем банк",
            category = Category.FINANCE,
            iconUrl = ""
        ),
        App(
            id = "2",
            name = "Яндекс Браузер",
            slogan = "Быстрый и безопасный браузер",
            category = Category.TOOLS,
            iconUrl = ""
        )
    )
    VKEducationAndroidKotlinTheme() {
        StoreContent(
            apps = apps,
            onClickToolbarLogo = {},
            onAppClick = {}
        )
    }
}