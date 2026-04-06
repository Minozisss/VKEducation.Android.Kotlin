package com.example.vkeducationandroidkotlin.activity

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
import com.example.vkeducationandroidkotlin.feature.appDetails.presentation.AppDetailsScreen
import com.example.vkeducationandroidkotlin.feature.store.presentation.StoreScreen
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
    const val DETAILS = "details/{id}"

    fun details(id: String): String = "details/$id"
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
            StoreScreen(
                onAppClick = { id ->
                    navController.navigate(Routes.details(id))
                }
            )
        }

        composable(Routes.DETAILS) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("id").orEmpty()

            AppDetailsScreen(
                id = appId,
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
