package com.aeab13.training.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Example3() {
    val currentValue = remember {
        mutableStateOf(0)
    }

    Column {
        Button(
            onClick = {
                currentValue.value++
            }
        ) {
            Text("Click me to increment")
        }
        Text(text = "Current value is ${currentValue.value}")
    }
}

@Preview
@Composable
fun Example3Preview() {
    Example3()
}