package com.aeab13.training

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun Example5LaunchedEffect() {
    val textFieldValue = remember {
        mutableStateOf("")
    }

    // Allows to access the context
    val currentContext = LocalContext.current

    // Executed just once when the composable is created
    LaunchedEffect(Unit) {
        Log.e("Example 5", "Launched effect just once from Example5", )
    }

    Column {
        TextField(
            value = textFieldValue.value,
            onValueChange = { newValue ->
                Log.e("Training", "LiveCoding: $newValue")
                textFieldValue.value = newValue
            },
            trailingIcon = {
                if (textFieldValue.value.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            textFieldValue.value = ""
                        }
                    )
                }
            }
        )

        Text("The text field value is ${textFieldValue.value}")
    }
}

@Composable
fun Example5DisposableEffect() {
    val isDialogVisible = remember {
        mutableStateOf(false)
    }

    Button(
        onClick = {
            isDialogVisible.value = true
        }
    ) {
        Text("Show dialog")
    }

    if (isDialogVisible.value) {
        MyCustomDialog(
            onDismissRequest = {
                isDialogVisible.value = false
            }
        )
    }
}

@Composable
fun MyCustomDialog(onDismissRequest: () -> Unit) {
    var countDown by remember {
        mutableStateOf(10)
    }

    LaunchedEffect(Unit) {
        Log.e("MyCustomDialog", "Disposable effect from MyCustomDialog", )

        while(countDown > 0) {
            delay(1000)
            countDown--
        }
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.es),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text("Dialog title", fontSize = 16.sp)
            }

        },
        text = {
            Text("Dialog text")
        },
        confirmButton = {
            Button(
                onClick = onDismissRequest,
                enabled = countDown == 0
            ) {
                Text(text = "OK (${countDown})")
            }
        },
    )
}
