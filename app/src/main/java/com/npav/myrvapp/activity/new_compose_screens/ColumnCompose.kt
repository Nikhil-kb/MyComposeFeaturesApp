package com.npav.myrvapp.activity.new_compose_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColumnCompose(

    title: String = "Title",
    content: String = "Content",
    backColor: Color = Color(0xFF44B9AE),
    actionIcon: ImageVector = Icons.Default.CheckCircle,
    onClick: () -> Unit
) {


    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 5.dp)
            .border(width = 0.dp, color = backColor, shape = RoundedCornerShape(5)),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = backColor)
                .padding(15.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = content,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Thin,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .size(width = 55.dp, height = 35.dp)
                    .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10))
                    .align(alignment = Alignment.End),
                elevation = 4.dp
            ) {
                Image(
                    imageVector = actionIcon,
                    contentDescription = "Redirect",
                    modifier = Modifier
                        .clickable {
                            onClick()
                        }
                        .size(31.dp)
                        .padding(vertical = 4.dp, horizontal = 4.dp)
                )
            }

        }

    }

}