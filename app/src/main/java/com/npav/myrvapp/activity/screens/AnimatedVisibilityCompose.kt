package com.npav.myrvapp.activity.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AnimatedVisibilityCompose() {

    var expand by remember{
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(20.dp),
        contentColor = Color.Black
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                expand = !expand
            }
        ) {

            Image(
                imageVector = Icons.Filled.CheckCircle, contentDescription = "",
                modifier = Modifier
                    .size(85.dp, 85.dp)
                    .padding(top = 35.dp, bottom = 15.dp)

            )

            AnimatedVisibility(visible = expand) {
                Text(
                    text = "Check filled icon",
                    modifier = Modifier.padding(top = 15.dp, bottom = 35.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        }

    }
}


