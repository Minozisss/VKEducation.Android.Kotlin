package com.example.vkeducationandroidkotlin.feature.appDetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationAndroidKotlinTheme {
                AppDetailsScreen(
                    Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                )
            }
        }
    }
}