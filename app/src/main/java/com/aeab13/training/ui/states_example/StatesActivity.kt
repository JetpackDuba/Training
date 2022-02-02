package com.aeab13.training.ui.states_example

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aeab13.training.ui.theme.TrainingTheme

private const val TAG = "StatesActivity"

class StatesActivity : ComponentActivity() {
    private val viewModel by viewModels<StatesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // For non-compose projects use this
//        lifecycleScope.launch {
//            viewModel.state.collect { updateState ->
//                Log.e(TAG, "new state is: ${updateState.javaClass.simpleName}", )
//            }
//        }

        setContent {
            TrainingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Status()
                }
            }
        }
    }

    @Composable
    fun Status() {
        val updateStatusState = viewModel.updateStatusFlow.collectAsState()

        val updateStatus: UpdateStatus = updateStatusState.value

        Log.e(TAG, "New update status is ${updateStatus::class.simpleName}", )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Show here info depending on the status
            when(updateStatus) {
                UpdateStatus.NoUpdates -> {
                    NoUpdates(
                        onCheckUpdates = {
                            viewModel.checkForUpdates()
                        }
                    )
                }
                UpdateStatus.CheckingUpdates -> {
                    CheckingUpdates()
                }
                is UpdateStatus.UpdateAvailable -> {
                    UpdateAvailable(
                        updateStatus = updateStatus,
                        onResetState = {
                            viewModel.resetState()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NoUpdates(
    onCheckUpdates: () -> Unit
) {
    Column {
        Text(text = "There are no updates available")
        Button(
            onClick = onCheckUpdates
        ) {
            Text(text = "Check for updates")
        }
    }
}

@Composable
fun CheckingUpdates() {
    Column {
        Text(text = "Searching for new updates")

        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun UpdateAvailable(
    updateStatus: UpdateStatus.UpdateAvailable,
    onResetState: () -> Unit,
) {
    Column {
        Text(text = "New update with version ${updateStatus.versionName} found")

        Button(
            onClick = onResetState
        ) {
            Text(text = "Reset status")
        }
    }
}

@Preview
@Composable
fun NoUpdatesPreview() {
    NoUpdates {}
}

@Preview
@Composable
fun CheckingUpdatesPreview() {
    CheckingUpdates()
}

@Preview
@Composable
fun UpdateAvailablePreview() {
    UpdateAvailable(updateStatus = UpdateStatus.UpdateAvailable("1.0.0")){}
}