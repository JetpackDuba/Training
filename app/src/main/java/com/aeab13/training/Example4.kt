package com.aeab13.training

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun LiveCodingTextField() {
    val textFieldValue = remember {
        mutableStateOf("")
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
private fun LiveCodingDialog() {
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
        AlertDialog(
            onDismissRequest = {
                isDialogVisible.value = false
            },
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
                    onClick = { isDialogVisible.value = false }
                ) {
                    Text(text = "OK")
                }
            },
        )
    }
}


@Preview
@Composable
fun LiveCodingPreview() {
    LiveCodingDialog()
}