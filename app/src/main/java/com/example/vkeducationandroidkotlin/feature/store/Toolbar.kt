package com.example.vkeducationandroidkotlin.feature.store

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ToolbarHeight = 92.dp
private val ToolbarHorizontalPadding = 16.dp
private val ToolbarIconTextSpacing = 8.dp
private val ToolbarTitleFontSize = 20.sp
private const val ToolbarTitle = "RuStore"
private const val ToolbarBlueGradientStartAlpha = 0.3f

private val IconBackgroundSize = 30.dp
private val IconBackgroundCornerRadius = 4.dp
private val IconBackgroundPadding = 2.dp

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    someToolbarButtonAction:() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Blue.copy(alpha = ToolbarBlueGradientStartAlpha),
                        Color.Blue
                    )
                )
            )
            .height(ToolbarHeight)
            .padding(horizontal = ToolbarHorizontalPadding)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconWithBackground(
                icon = Icons.Default.Home,
                tint = Color.Blue,
                backgroundColor = Color.White
            )

            Spacer(
                modifier = Modifier.width(ToolbarIconTextSpacing)
            )

            Text(
                ToolbarTitle,
                color = Color.White,
                fontSize = ToolbarTitleFontSize,
                fontWeight = FontWeight.Bold
            )
        }

        IconButton(
            onClick = someToolbarButtonAction
        ) {
            IconWithBackground(
                icon = Icons.Default.AccountBox,
                tint = Color.White,
                backgroundColor = Color.White.copy(alpha = 0.2f)
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
    Toolbar() { }
}
