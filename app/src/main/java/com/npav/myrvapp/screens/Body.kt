package com.npav.myrvapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Body() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.background(color = Color.White).fillMaxSize()
    ) {

        Text(text = "Content at center", color = Color.Black)
       /*Column(verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.background(color = Color.White)
           ) {



       }*/
    }
    
}