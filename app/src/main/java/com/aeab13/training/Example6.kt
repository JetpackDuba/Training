package com.aeab13.training

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Example6() {
    var isImageVisible by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                isImageVisible = !isImageVisible
            }
        ) {
            Text(text = "Change visibility")
        }

        AnimatedVisibility(
            visible = isImageVisible,
            enter = slideInHorizontally()
        ) {
            Column {
                Text("Earthshaker")
                Image(
                    painter = painterResource(id = R.drawable.es),
                    contentDescription = null,
                )
            }
        }

    }
}