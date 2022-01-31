package com.aeab13.training

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aeab13.training.ui.theme.TrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingTheme {
                PracticeSolution(fruits)
            }
        }
    }

    @Composable
    fun Practice(fruitsList: List<String>) {

    }

    @Preview
    @Composable
    fun PracticePreview() {
        Practice(fruits)
    }
}