package com.aeab13.training.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.aeab13.training.ui.theme.TrainingTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadData()

        setContent {
            TrainingTheme {
                Practice()
            }
        }
    }

    @Composable
    fun Practice() {
        // Todo get the data from the view model and update the UI
        // There are 3 views to represent each UI state: LoadingView, ErrorView, FruitsView.
    }
}