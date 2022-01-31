package com.aeab13.training.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aeab13.training.R

//region Text
@Composable
fun MostUsedComposables_Text() {
    Text(
        text = "Hello World!",
        color = Color.Blue,
        fontFamily = FontFamily.Monospace,
    )
}

@Preview
@Composable
fun MostUsedComposables_Text_Preview() { MostUsedComposables_Text() }
//endregion

//region Column
@Composable
fun MostUsedComposables_Column() {
    Column {
        Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        Text(text = "Person")
    }
}

@Preview
@Composable
fun MostUsedComposables_Column_Preview() { MostUsedComposables_Column() }
//endregion

//region Row
@Composable
fun MostUsedComposables_Row() {
    Row {
        Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        Text(text = "Person")
    }
}

@Preview
@Composable
fun MostUsedComposables_Row_Preview() { MostUsedComposables_Row() }
//endregion

//region Box

@Composable
fun MostUsedComposables_Box() {
    Box {
        Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        Text(text = "Person")
    }
}

@Preview
@Composable
fun MostUsedComposables_Box_Preview() { MostUsedComposables_Box() }

//endregion

//region Button
@Composable
fun MostUsedComposables_Button() {
    Button(
        onClick = { /*TODO do something */ },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
    ) {
        Text(text = "Click me!")
    }
}

@Preview
@Composable
fun MostUsedComposables_Button_Preview() { MostUsedComposables_Button() }
//endregion

//region TextField
@Composable
fun MostUsedComposables_TextField() {
    var textValue by remember { mutableStateOf("") }
    TextField(
        value = textValue,
        onValueChange = { value -> textValue = value }
    )
}

@Preview
@Composable
fun MostUsedComposables_TextField_Preview() { MostUsedComposables_TextField() }
//endregion

//region Image
@Composable
fun MostUsedComposables_Image() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.es),
            contentDescription = "Earthshaker",
            modifier = Modifier.size(128.dp),
        )
        Image(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account icon",
            modifier = Modifier.size(128.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        )
    }

}

@Preview
@Composable
fun MostUsedComposables_Image_Preview() { MostUsedComposables_Image() }
//endregion

//region LazyColumn
@OptIn(ExperimentalFoundationApi::class) // added to use stickyHeader
@Composable
fun MostUsedComposables_LazyColumn() {
    val itemsList = listOf("A", "B", "C")
    LazyColumn {

        // Non-sticky header
        item {
            Text(text = "Header")
        }

        // Sticky header
        stickyHeader {
            Text(text = "Sticky header")
        }

        // Be sure to add the import [androidx.compose.foundation.lazy.items]
        items(itemsList) { item ->
            Text(text = item)
        }

        item {
            Text(text = "List footer")
        }
    }
}

@Preview
@Composable
fun MostUsedComposables_LazyColumn_Preview() { MostUsedComposables_LazyColumn() }
//endregion

//region Scaffold
@Composable
fun MostUsedComposables_Scaffold() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO do something*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        // Screen's content
    }
}

@Preview
@Composable
fun MostUsedComposables_Scaffold_Preview() { MostUsedComposables_Scaffold() }
//endregion