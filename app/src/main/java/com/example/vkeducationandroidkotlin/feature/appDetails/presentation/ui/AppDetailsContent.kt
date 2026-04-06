package com.example.vkeducationandroidkotlin.feature.appDetails.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.R
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetails
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

@Composable
fun AppDetailsContent(
    appDetails: AppDetails,
    modifier: Modifier = Modifier.safeDrawingPadding(),
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_developement)

    var descriptionCollapsed by remember { mutableStateOf(false) }

    Column(modifier) {
        Toolbar(
            onBackClick = {
                onBackClick()
            },
            onShareClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = appDetails.screenshotUrlList,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = {
                descriptionCollapsed = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appDetails.developer,
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    val appDetails = AppDetails(
        id = "1",
        name = "Сбербанк Онлайн - с Салютом",
        developer = "Сбербанк",
        category = Category.FINANCE,
        ageRating = 18,
        size = 130.0,
        iconUrl = "",
        screenshotUrlList = listOf(),
        description = "Description"
    )

    VKEducationAndroidKotlinTheme {
        AppDetailsContent(
            appDetails = appDetails,
            onBackClick = {}
        )
    }
}