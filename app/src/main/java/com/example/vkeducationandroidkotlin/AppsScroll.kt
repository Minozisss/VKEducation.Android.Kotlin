package com.example.vkeducationandroidkotlin

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

@Composable
fun AppsScroll(
    modifier: Modifier = Modifier,
    items: List<AppItem>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    ) {
        itemsIndexed(items) { index, app ->
            AppCell(
                modifier = Modifier,
                item = app
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (index < items.lastIndex) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(8.dp))
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