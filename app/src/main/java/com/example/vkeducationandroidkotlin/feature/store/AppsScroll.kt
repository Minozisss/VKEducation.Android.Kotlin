package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val AppsScrollContentPaddingHorizontal = 16.dp
private val AppsScrollContentPaddingVertical = 16.dp
private val AppsScrollItemSpacing = 8.dp
private val AppsScrollDividerThickness = 1.dp

@Composable
fun AppsScroll(
    modifier: Modifier = Modifier,
    items: List<AppItem>,
    onAppClick: (AppItem) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        contentPadding = PaddingValues(
            horizontal = AppsScrollContentPaddingHorizontal,
            vertical = AppsScrollContentPaddingVertical
        )
    ) {
        itemsIndexed(items) { index, app ->
            AppCell(
                modifier = Modifier,
                item = app,
                onClick = {
                    onAppClick(app)
                }
            )

            Spacer(modifier = Modifier.height(AppsScrollItemSpacing))

            if (index < items.lastIndex) {
                HorizontalDivider(
                    thickness = AppsScrollDividerThickness,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(AppsScrollItemSpacing))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppsScroll(
        modifier = Modifier,
        items = listOf(
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
            )
        )
    )
}
