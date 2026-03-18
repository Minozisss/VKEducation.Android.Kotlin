package com.example.vkeducationandroidkotlin.feature.store.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.domain.App
import com.example.vkeducationandroidkotlin.domain.Category

private val AppsScrollContentPaddingHorizontal = 16.dp
private val AppsScrollContentPaddingVertical = 16.dp
private val AppsScrollItemSpacing = 8.dp

@Composable
fun AppList(
    modifier: Modifier = Modifier,
    items: List<App>,
    onAppClick: (App) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            ),
        contentPadding = PaddingValues(
            horizontal = AppsScrollContentPaddingHorizontal,
            vertical = AppsScrollContentPaddingVertical
        ),
        verticalArrangement = Arrangement.spacedBy(AppsScrollItemSpacing)
    ) {
        itemsIndexed(items) { index, app ->
            AppListItem(
                modifier = Modifier,
                item = app,
                isDividerShowing = index < items.lastIndex,
                onClick = { onAppClick(app) }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val items = listOf(
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
        )
    )

    AppList(
        modifier = Modifier,
        items = items,
        onAppClick = { }
    )
}