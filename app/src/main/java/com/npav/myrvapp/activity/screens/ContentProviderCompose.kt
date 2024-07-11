package com.npav.myrvapp.activity.screens

import android.content.ContentResolver
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ContentProviderCompose(words: String) {


    Box(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
        ){

        Text(text = words)

    }

}