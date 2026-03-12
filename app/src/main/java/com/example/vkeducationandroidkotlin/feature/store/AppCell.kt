package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val AppCellMinHeight = 88.dp
private val AppCellIconSize = 72.dp
private val AppCellHorizontalSpacing = 8.dp
private val AppCellTitleFontSize = 16.sp
private val AppCellSubtitleFontSize = 14.sp
private const val AppCellTextMaxLines = 1

@Composable
fun AppCell(
    modifier: Modifier,
    item: AppItem,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .heightIn(min = AppCellMinHeight)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            modifier = Modifier
                .size(AppCellIconSize)
        )

        Spacer(modifier = Modifier.width(AppCellHorizontalSpacing))

        Column(
            modifier = Modifier
                .weight(1f)
                .height(AppCellIconSize),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = AppCellTitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = item.slogan,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = AppCellSubtitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = item.category,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = AppCellSubtitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppCell(
        modifier = Modifier,
        item = AppItem(
            icon = Icons.Default.Home,
            title = "Сбербанк Онлайн - с Салютом",
            slogan = "Больше чем банк",
            category = "Финансы"
        )
    )
}
