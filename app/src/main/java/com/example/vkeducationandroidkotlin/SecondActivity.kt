package com.example.vkeducationandroidkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = intent.getStringExtra("input_text") ?: "Текст не передан"

        setContent {
            SecondScreen(text = text)
        }
    }
}

@Composable
fun SecondScreen(text: String) {
    Text(text = text)
}