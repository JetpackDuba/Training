package com.aeab13.training.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aeab13.training.R

@Composable
fun Example1() {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.es),
            contentDescription = "Cute pic",
            modifier = Modifier
                .padding(vertical = 8.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Screen nº1",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview
@Composable
fun Example1Preview() {
    Example1()
}