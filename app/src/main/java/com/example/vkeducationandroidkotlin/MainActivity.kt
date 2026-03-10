package com.example.vkeducationandroidkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationandroidkotlin.ui.theme.VKEducationAndroidKotlinTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val EXTRA_INPUT_TEXT = "input_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VKEducationAndroidKotlinTheme {
                MainScreen(
                    onOpenSecondActivity = { inputText ->
                        if (inputText.isBlank()) {
                            val errorMessage = "Введите текст для открытия SecondActivity"

                            showToast(
                                this@MainActivity,
                                errorMessage
                            )
                        } else {
                            val intent = Intent(
                                this@MainActivity,
                                SecondActivity::class.java
                            ).apply {
                                putExtra(EXTRA_INPUT_TEXT, inputText)
                            }

                            startActivity(intent)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onOpenSecondActivity: (String) -> Unit
) {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onOpenSecondActivity(inputText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть Second Activity")
        }
    }
}

fun showToast(
    context: Context,
    text: String
) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_LONG
    ).show()
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    VKEducationAndroidKotlinTheme {
        MainScreen { }
    }
}