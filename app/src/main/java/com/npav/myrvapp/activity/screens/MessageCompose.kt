package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.npav.myrvapp.R
import com.npav.myrvapp.activity.models.MessageData

@Composable
fun MessageCompose(messageData: MessageData) {

    Box(modifier = Modifier) {

        Row() {

            Image(
                painter = painterResource(id = R.drawable.spenish_flag),
                contentDescription = "profile",
                modifier = Modifier
                    .padding(10.dp)
                    .clip(shape = CircleShape)
                    .size(40.dp)
                    .border(width = 2.dp, color = Color.DarkGray, shape = CircleShape)

            )

            Spacer(modifier = Modifier.width(8.dp))

            Column() {

                Text(
                    text = messageData.userName,
                    style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier.padding(top = 10.dp, end = 8.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    elevation = 2.dp,
                    backgroundColor = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = messageData.message,
                        style = TextStyle(fontWeight = FontWeight.Medium, color = Color.DarkGray),
                        modifier = Modifier.padding(7.dp)
                    )
                }


            }

        }

    }

}