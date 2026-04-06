package com.example.vkeducationandroidkotlin.feature.store.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkeducationandroidkotlin.feature.appDetails.AppDetailsScreen
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationAndroidKotlinTheme {
                AppNavHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

private object Routes {
    const val STORE = "store"
    const val DETAILS = "details"
}

@Composable
private fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.STORE,
        modifier = modifier
    ) {
        composable(Routes.STORE) {
            _root_ide_package_.com.example.vkeducationandroidkotlin.feature.store.StoreScreen(
                onAppClick = {
                    navController.navigate(Routes.DETAILS)
                }
            )
        }

        composable(Routes.DETAILS) {
            AppDetailsScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
