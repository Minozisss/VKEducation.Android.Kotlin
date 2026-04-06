package com.example.vkeducationandroidkotlin.feature.appDetails.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkeducationandroidkotlin.ui.theme.RuStoreBlack
import com.example.vkeducationandroidkotlin.ui.theme.RuStoreMagenta
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

@Composable
internal fun Toolbar(
    onBackClick: () -> Unit,
    isInWishList: Boolean,
    onWishListClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
        Row {
            IconButton(onClick = onWishListClick) {
                Icon(
                    imageVector = if (isInWishList) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    },
                    contentDescription = null,
                    tint = if (isInWishList) RuStoreMagenta else RuStoreBlack
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VKEducationAndroidKotlinTheme {
        Toolbar(
            onBackClick = {},
            isInWishList = false,
            onWishListClick = {},
            onShareClick = {},
        )
    }
}
