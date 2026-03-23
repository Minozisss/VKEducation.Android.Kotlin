package com.example.vkeducationandroidkotlin.feature.store.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.vkeducationandroidkotlin.core.domain.Category
import com.example.vkeducationandroidkotlin.feature.store.domain.App
import com.example.vkeducationandroidkotlin.feature.store.presentation.views.AppList
import com.example.vkeducationandroidkotlin.feature.store.presentation.views.Toolbar
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

private val StoreListTopCornerRadius = 24.dp

@Composable
fun StoreScreen(
    onAppClick: (id: String) -> Unit
) {
    val viewModel: StoreViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is StoreEvents.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        when (val currentState = state) {
            is StoreState.Content -> {
                StoreContent(
                    modifier = Modifier,
                    apps = currentState.apps,
                    onClickToolbarLogo = {
                        viewModel.showSnackbar()
                    },
                    onAppClick = onAppClick
                )
            }
            StoreState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Some Error")
                }
            }
            StoreState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun StoreContent(
    modifier: Modifier = Modifier,
    apps: List<App>,
    onClickToolbarLogo: () -> Unit,
    onAppClick: (id: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Toolbar(
            onClickToolbarLogo = onClickToolbarLogo,
            onClickToolbarButton = { } // правда не знаю, что она делает :)
        )

        AppList(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .clip(
                    RoundedCornerShape(
                        topStart = StoreListTopCornerRadius,
                        topEnd = StoreListTopCornerRadius
                    )
                ),
            items = apps,
            onAppClick = onAppClick
        )
    }
}

@Preview
@Composable
private fun Preview() {
     val apps: List<App> = listOf(
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
    VKEducationAndroidKotlinTheme() {
        StoreContent(
            apps = apps,
            onClickToolbarLogo = {},
            onAppClick = {}
        )
    }
}
