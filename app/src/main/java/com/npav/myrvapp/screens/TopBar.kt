package com.npav.myrvapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TopBar(onMenuClicked:() -> Unit ) {

    TopAppBar(
        title = { Text(text = "Sample TopAppBar", color = Color.White) },
        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.White)
        },
        backgroundColor = Color(0xFF0F9D58)
    )

}