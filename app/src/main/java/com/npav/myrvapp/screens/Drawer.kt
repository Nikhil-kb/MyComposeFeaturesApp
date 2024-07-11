package com.npav.myrvapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.npav.myrvapp.R;

@Composable
fun Drawer() {
    Column(
        Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF0F9D58))
                .fillMaxWidth(1f)
                .padding(bottom = 15.dp, top = 20.dp),
            contentAlignment = Alignment.TopStart
        ) {

            Row (
               modifier = Modifier.padding(8.dp)
                    ){

                Image(
                    painter = painterResource(id = R.drawable.spenish_flag),
                    contentDescription = "Profile image",
                    modifier = Modifier
                        .weight(0.2f)
                        .size(70.dp, 70.dp)
                        .clip(CircleShape)
                        .background(color = Color.White)
                        .border(width = 1.dp, color = Color.Gray)
                )

                Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(start = 10.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(text = "Name: Sample name", color = Color.White, modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Email: abc123456@gmail.com", color = Color.White, modifier = Modifier.padding(bottom = 5.dp))
                    Text(text = "Mobile no: 9876543210", color = Color.White, modifier = Modifier.padding(bottom = 5.dp))

                }

            }

        }

        Spacer(modifier = Modifier.height(height = 15.dp))

        Box(modifier = Modifier.padding(start = 15.dp, end = 15.dp)){
            Column(
                Modifier
                    .background(color = Color.White)
                    .fillMaxSize()
            ){
                repeat(5) {
                    Text(text = "Associated item: $it", color = Color.Black, modifier = Modifier.padding(bottom = 10.dp))
                }
            }

        }

    }
}