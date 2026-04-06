package com.example.vkeducationandroidkotlin.feature.store.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.feature.store.domain.App

private val AppsScrollItemSpacing = 8.dp
private val AppsScrollDividerThickness = 1.dp

@Composable
fun AppListItem(
    modifier: Modifier = Modifier,
    item: App,
    isDividerShowing: Boolean,
    onClick: () -> Unit
) {
    Column(
    modifier = modifier
    ) {
        AppCell(
            item = item,
            onClick = onClick
        )

        if (isDividerShowing) {
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = AppsScrollItemSpacing),
                thickness = AppsScrollDividerThickness,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}