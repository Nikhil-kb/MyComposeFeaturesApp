@file:OptIn(ExperimentalMaterialApi::class)

package com.npav.myrvapp.activity.new_compose_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExposedDropdownBoxCompose() {

    val spinnerList = listOf(
        "Botnet", "Ransomware", "Spyware", "Adware", "Keylogger", "Rootkits", "Fileless Malware"
    )

    var expanded by remember {
        mutableStateOf(
            false
        )
    }

    var selectedOptionTex by remember {
        mutableStateOf(spinnerList[0])
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        ) {

        /*   TextField(
               value = selectedOptionTex,
               onValueChange = {},
               readOnly = true,
               colors = ExposedDropdownMenuDefaults.textFieldColors(),
               trailingIcon = {
                   ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
               },
               label = {
                   Text("Type of malware")
               }
           )*/

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 8.dp, top = 5.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedOptionTex,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )

                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            }


        }

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            spinnerList.forEach {

                DropdownMenuItem(onClick = {
                    selectedOptionTex = it
                    expanded = false
                }) {
                    Text(
                        text = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }

        }
    }


}