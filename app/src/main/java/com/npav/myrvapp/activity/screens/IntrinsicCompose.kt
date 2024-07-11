package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IntrinsicCompose() {

    Box(
        modifier = Modifier
    ) {

        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(
                text = "Start Text",
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .wrapContentWidth(Alignment.Start)
            )

            Divider(modifier = Modifier.fillMaxHeight().width(1.dp).background(color = Color.Black))

            Text(
                text = "End Text",
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .wrapContentWidth(Alignment.End)
            )

        }



    }

}