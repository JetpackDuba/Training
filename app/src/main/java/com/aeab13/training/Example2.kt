package com.aeab13.training

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Example2() {
    val androidVersions = listOf(
        "Froyo",
        "Gingerbread",
        "Honeycomb",
        "Ice Cream Sandwich",
        "Jelly Bean",
    )

    LazyColumn (modifier = Modifier.fillMaxSize()) {
        items(androidVersions) { version ->
            AndroidVersion(version)
        }
    }
}

@Composable
fun AndroidVersion(version: String) {
    Text(
        text = version,
        modifier = Modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    )
}

@Preview
@Composable
fun Example2Preview() {
    Example2()
}