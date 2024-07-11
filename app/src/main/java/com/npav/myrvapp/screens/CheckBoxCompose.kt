package com.npav.myrvapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxCompose() {

    val checkState = remember{ mutableStateOf(true) }

    Box() {
        Row(
            modifier = Modifier.height(50.dp),

        ) {

            Checkbox(checked = checkState.value, onCheckedChange = {
                checkState.value = it
            },
                modifier = Modifier.size(width = 25.dp, height = 25.dp).align(alignment = Alignment.CenterVertically)
                ,
                colors = CheckboxDefaults.colors(checkedColor = Color.Red, uncheckedColor = Color.Green, disabledColor = Color.Black, checkmarkColor = Color.Yellow)
            )

            Text(text = "Study Material", modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterVertically))

        }
    }



}