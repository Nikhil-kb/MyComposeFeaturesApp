package com.npav.myrvapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun GradientCardCompose() {

    var brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFDAD36),
            Color(0xFFFFAC30),
            Color(0xFFF79C16),
            Color(0xFFEC8E04)
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Cyan, Color.Green)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        ) {
            Box(
                Modifier
                    .background(brush = gradient)
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Text("Hello from Jetpack Compose!", Modifier.padding(16.dp))
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp, horizontal = 16.dp)

            ) {

                Row(
                    modifier = Modifier.background(brush = brush).height(100.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "This is a sample sentence for demo",
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.width(150.dp).padding(horizontal = 5.dp)
                    )

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Check",
                        tint = Color.White,
                        modifier = Modifier.size(45.dp).padding(horizontal = 5.dp)
                    )

                }

            }

        }


    }


}