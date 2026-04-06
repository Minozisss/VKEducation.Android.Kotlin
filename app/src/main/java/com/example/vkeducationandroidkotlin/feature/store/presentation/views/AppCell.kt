package com.example.vkeducationandroidkotlin.feature.store.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.vkeducationandroidkotlin.R
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.store.domain.App

private val AppCellMinHeight = 88.dp
private val AppCellIconSize = 72.dp
private val AppCellHorizontalSpacing = 8.dp
private val AppCellTitleFontSize = 16.sp
private val AppCellSubtitleFontSize = 14.sp
private const val AppCellTextMaxLines = 1

@Composable
fun AppCell(
    modifier: Modifier = Modifier,
    item: App,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .heightIn(min = AppCellMinHeight)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        AsyncImage(
            model = item.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(AppCellIconSize)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(AppCellHorizontalSpacing))

        Column(
            modifier = Modifier
                .weight(1f)
                .height(AppCellIconSize),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.name,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.SemiBold,
                fontSize = AppCellTitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = item.slogan,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Normal,
                fontSize = AppCellSubtitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = getCategoryText(item.category),
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Normal,
                fontSize = AppCellSubtitleFontSize,
                maxLines = AppCellTextMaxLines,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
    Category.FINANCE -> stringResource(R.string.category_finance)
    Category.TOOLS -> stringResource(R.string.category_tools)
    Category.TRANSPORTATION -> stringResource(R.string.category_transportation)
    Category.OTHER -> stringResource(R.string.category_other)
}

@Preview
@Composable
private fun Preview() {
    val item = App(
        id = "1",
        name = "Сбербанк Онлайн - с Салютом",
        slogan = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = ""
    )

    AppCell(
        modifier = Modifier,
        item = item,
        onClick = { }
    )
}
