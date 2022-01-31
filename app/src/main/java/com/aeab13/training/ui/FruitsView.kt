package com.aeab13.training.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aeab13.training.fruits

@Composable
fun FruitsView(fruitsList: List<String>) {
    var filter by remember {
        mutableStateOf("")
    }

    val (selectedFruit, setSelectedFruit) = remember {
        mutableStateOf<String?>(null)
    }

    val displayedFruitsList = remember(filter, fruitsList) {
        filterFruits(filter, fruitsList)
    }

    if (selectedFruit != null) {
        FruitDialog(
            currentlySelectedFruit = selectedFruit,
            onDismiss = {
                setSelectedFruit(null)
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchField(
            filter = filter,
            onValueChange = { newFilterValue ->
                filter = newFilterValue
            },
            modifier = Modifier.fillMaxWidth()
        )

        FruitsList(
            fruits = displayedFruitsList,
            onFruitClicked = { fruit -> setSelectedFruit(fruit) }
        )

    }
}

@Composable
fun FruitDialog(currentlySelectedFruit: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text("You have clicked on $currentlySelectedFruit")
        },
        buttons = {
            Row {
                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onDismiss) {
                    Text("Close")
                }
            }
        }
    )
}

@Composable
fun FruitsList(fruits: List<String>, onFruitClicked: (String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(fruits) { fruit ->
            Fruit(
                fruit = fruit,
                onFruitClicked = { onFruitClicked(fruit) }
            )
        }
    }
}

@Composable
fun SearchField(filter: String, onValueChange: (String) -> Unit, modifier: Modifier) {
    OutlinedTextField(
        value = filter,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth()
            .padding(8.dp),
        trailingIcon = {
            if (filter.isNotBlank()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear",
                    modifier = Modifier.clickable {
                        onValueChange("")
                    }

                )
            }
        }
    )
}

fun filterFruits(filter: String, fruitsList: List<String>): List<String> {
    return if (filter.isBlank()) {
        fruitsList
    } else {
        fruitsList.filter { item ->
            item.lowercase().contains(filter.lowercase())
        }
    }
}

@Composable
fun Fruit(fruit: String, onFruitClicked: () -> Unit) {
    Text(
        text = fruit,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onFruitClicked() }
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
    )
}

@Preview
@Composable
fun FruitsViewPreview() {
    FruitsView(fruits)
}