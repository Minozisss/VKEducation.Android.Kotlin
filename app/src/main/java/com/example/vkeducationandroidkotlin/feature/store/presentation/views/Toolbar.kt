package com.example.vkeducationandroidkotlin.feature.store.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkeducationandroidkotlin.R
import com.example.vkeducationandroidkotlin.ui.theme.RuStoreWhite
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

private val ToolbarHeight = 92.dp
private val ToolbarHorizontalPadding = 16.dp
private val ToolbarIconTextSpacing = 8.dp
private val ToolbarTitleFontSize = 20.sp
private const val ToolbarTitle = "RuStore"
private val IconBackgroundSize = 30.dp
private val IconBackgroundCornerRadius = 4.dp
private val IconBackgroundPadding = 2.dp

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    onClickToolbarLogo: () -> Unit,
    onClickToolbarButton:() -> Unit // правда не знаю, что она делает :)
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primary,
            )
            .height(ToolbarHeight)
            .padding(horizontal = ToolbarHorizontalPadding)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClickToolbarLogo),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // С белым фоном не нашлась. Видимо, уже не используете. Искал на https://www.rustore.ru/media-kit
            Image(
                painter = painterResource(id = R.drawable.rustore_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )

            Spacer(
                modifier = Modifier.width(ToolbarIconTextSpacing)
            )

            Text(
                ToolbarTitle,
                color = RuStoreWhite,
                fontSize = ToolbarTitleFontSize,
                fontWeight = FontWeight.Bold
            )
        }

        IconButton(
            onClick = onClickToolbarButton
        ) {
            IconWithBackground(
                icon = Icons.Outlined.GridView,
                tint = RuStoreWhite,
                backgroundColor = MaterialTheme.colorScheme.background.copy(alpha = 0.2f)
            )
        }
    }
}

@Composable
fun IconWithBackground(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    tint: Color,
    backgroundColor: Color
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = tint,
        modifier = modifier
            .size(IconBackgroundSize)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(IconBackgroundCornerRadius)
            )
            .padding(IconBackgroundPadding)
    )
}

@Preview
@Composable
private fun Preview() {
    VKEducationAndroidKotlinTheme() {
        Toolbar(
            onClickToolbarLogo = {},
            onClickToolbarButton = {}
        )
    }
}
