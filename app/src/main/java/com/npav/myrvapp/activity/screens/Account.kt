package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Account(openDrawer: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopBar(
            imgVector = Icons.Filled.AccountBox,
            title = "Account",
            onButtonClicked = {
                openDrawer()
            }
        )
        
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Account content")
        }
        
    }

    

}