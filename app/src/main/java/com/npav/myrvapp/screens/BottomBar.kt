package com.npav.myrvapp.screens

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun BottomBar() {
    BottomAppBar(backgroundColor = Color(0xFF0F9D58)) {

        Text(text = "Secure scan", color = Color.White, modifier = Modifier.weight(0.5f), textAlign = TextAlign.Center)
        Text(text = "Analyze free storage", color = Color.White, modifier = Modifier.weight(0.5f), textAlign = TextAlign.Center)
    }
}

