package com.aeab13.training

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aeab13.training.ui.theme.primaryTextColor

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Example7_Box() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(96.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colors.primaryVariant)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(96.dp)
                .background(MaterialTheme.colors.primaryTextColor)
        )
    }
}