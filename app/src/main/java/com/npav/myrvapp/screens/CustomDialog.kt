package com.npav.myrvapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog;

@Composable
fun CustomDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val textFieldError = remember {
        mutableStateOf("")
    }

    val textField = remember {
        mutableStateOf(value)
    }

    Dialog(onDismissRequest = { setShowDialog(false)}) {
        Box(
            modifier = Modifier.clip(shape = RoundedCornerShape(30.dp)).background(Color.White),
            contentAlignment = Alignment.Center
        ) {

            Column(modifier = Modifier.padding(20.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Set value",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Default
                        ),
                        modifier = Modifier
                    )

                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "cancel",
                        tint = colorResource(id = android.R.color.black),
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clickable {
                                setShowDialog(false)
                            }

                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            BorderStroke(
                                width = 2.dp,
                                color = colorResource(id = if (textFieldError.value.isEmpty()) android.R.color.holo_green_light else android.R.color.holo_red_dark)
                            ),
                            shape = RoundedCornerShape(50)
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = colorResource(id = android.R.color.darker_gray),
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    },
                    placeholder = { Text(text = "Enter value") },
                    value = textField.value,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = {
                        textField.value = it.take(10)
                    })

                Spacer(modifier = Modifier.height(20.dp))

                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = {
                        if (textField.value.isEmpty()) {
                            textField.value = "Field can not be empty"
                            return@Button
                        }
                        setShowDialog(false)
                        setValue(textField.value)
                    }) {
                        Text(text = "Submit")
                    }
                }

            }

        }
    }


}