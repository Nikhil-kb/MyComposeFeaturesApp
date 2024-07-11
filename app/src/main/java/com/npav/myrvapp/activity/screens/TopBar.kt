package com.npav.myrvapp.activity.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(title:String = "", imgVector: ImageVector, onButtonClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(text = title, style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold))
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(imageVector = imgVector, contentDescription = "Navigation icon")
            }
        },
        backgroundColor = Color.Green
    )

}


