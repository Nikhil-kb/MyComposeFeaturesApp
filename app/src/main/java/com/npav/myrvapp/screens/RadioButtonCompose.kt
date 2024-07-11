package com.npav.myrvapp.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonCompose() {

    val radioOptions = listOf("Adware", "Ransomware", "DDOS", "Fishing", "Smishing")

    var (selectedOption, onOptionSelected) = remember {
        mutableStateOf(radioOptions[2])
    }

    var selectedText by remember {
        mutableStateOf("Adware")
    }


    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        radioOptions.forEach { text ->

            Row(modifier = Modifier
                .size(width = 180.dp, height = 50.dp)
                .selectable(
                    selected = text == selectedText,
                    onClick = {
                        selectedText = text
                        //onOptionSelected(text)
                        Toast
                            .makeText(context, "Selected option: $text", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
                .padding(vertical = 2.dp, horizontal = 4.dp)
                .border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically
                ) {

                RadioButton(
                    selected = text == selectedText,
                    onClick = {
                        selectedText = text
                       // onOptionSelected(text)
                        Toast.makeText(context, "Selected option: $text", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.padding(all = Dp(value = 4F)),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                        unselectedColor = Color.LightGray
                    )
                )

                Text(text = text, modifier = Modifier.padding(vertical = 4.dp))

            }

        }

    }


}