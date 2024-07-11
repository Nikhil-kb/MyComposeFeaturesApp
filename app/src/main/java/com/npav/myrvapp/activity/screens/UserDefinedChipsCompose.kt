package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.google.android.material.color.utilities.MaterialDynamicColors.background


@Composable
fun UserDefinedChipsCompose(item: String) {

    Box(modifier = Modifier
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(50.dp))



    ){
        Text(text = item,
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 15.dp),
            style = TextStyle(color = Color.Black, fontFamily = FontFamily.Serif)
            )
    }

}