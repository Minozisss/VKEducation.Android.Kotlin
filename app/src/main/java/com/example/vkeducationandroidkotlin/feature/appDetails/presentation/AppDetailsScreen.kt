package com.example.vkeducationandroidkotlin.feature.appDetails.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.vkeducationandroidkotlin.feature.appDetails.presentation.ui.AppDetailsContent

@Composable
fun AppDetailsScreen(
    onBackClick: () -> Unit = {},
) {
    val viewModel: AppDetailsViewModel = hiltViewModel()

    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppDetailsState.Content -> {
            AppDetailsContent(
                appDetails = currentState.appDetails,
                onBackClick = onBackClick
            )
        }

        AppDetailsState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Some Error")
            }
        }

        AppDetailsState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
