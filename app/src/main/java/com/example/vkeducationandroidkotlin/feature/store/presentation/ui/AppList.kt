package com.example.vkeducationandroidkotlin.feature.store.presentation.ui

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
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.store.domain.App

private val AppsScrollContentPaddingHorizontal = 16.dp
private val AppsScrollContentPaddingVertical = 16.dp
private val AppsScrollItemSpacing = 8.dp

@Composable
fun AppList(
    modifier: Modifier = Modifier,
    items: List<App>,
    onAppClick: (id: String) -> Unit
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
                onClick = { onAppClick(app.id) }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val items = listOf(
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

    AppList(
        modifier = Modifier,
        items = items,
        onAppClick = { }
    )
}