package com.npav.myrvapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun ConstraintLayoutCompose() {

    Surface(
        modifier = Modifier.background(color = Color.Gray)
    ) {

        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (firstElement, secondElement, thirdElement, rowElement) = createRefs()

            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .constrainAs(firstElement) {
                        start.linkTo(parent.start, 10.dp)
                        top.linkTo(parent.top, 22.dp)
                        width = Dimension.fillToConstraints
                    }.aspectRatio(2f/3f)
            )

            Text(
                text = "Large Title",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 22.sp
                ),
                modifier = Modifier.constrainAs(secondElement) {
                    top.linkTo(firstElement.bottom, 5.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Text(
                text = "Large Title",
                style = TextStyle(
                    fontWeight = FontWeight.Thin,
                    color = Color.Black,
                    fontSize = 18.sp
                ),
                modifier = Modifier.constrainAs(thirdElement) {
                    top.linkTo(secondElement.bottom, 5.dp)
                    start.linkTo(parent.start, 10.dp)
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(rowElement) {
                        start.linkTo(firstElement.end, 10.dp)
                        top.linkTo(parent.top, 22.dp)
                    },
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "1234567890",
                    style = TextStyle(
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "1234567890",
                    style = TextStyle(
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "1234567890",
                    style = TextStyle(
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(5.dp)
                )

            }

        }

    }

}