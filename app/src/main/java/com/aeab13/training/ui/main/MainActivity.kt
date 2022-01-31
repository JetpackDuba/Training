package com.aeab13.training.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint
import com.aeab13.training.ui.ErrorView
import com.aeab13.training.ui.FruitsView
import com.aeab13.training.ui.LoadingView
import com.aeab13.training.ui.theme.TrainingTheme

@AndroidEntryPoint
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
        val mainViewState by viewModel.mainViewState.collectAsState()

        when(val state = mainViewState) {
            MainViewState.Loading -> {
                LoadingView()
            }
            is MainViewState.Complete -> {
                FruitsView(fruitsList = state.fruitsList)
            }
            is MainViewState.Error -> {
                ErrorView(state.exception)
            }
        }
    }
}