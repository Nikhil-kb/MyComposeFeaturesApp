package com.npav.myrvapp.activity.new_compose_screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SwitchCompose() {

    var switchState by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.size(width = 50.dp, height = 35.dp).border(width = 1.dp, color = Color.DarkGray ,shape = RoundedCornerShape(20.dp))
    ) {

        Switch(checked = switchState,
            onCheckedChange = {
                switchState = it
            },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Blue,
            checkedTrackColor = Color.DarkGray,
            uncheckedThumbColor = Color.Gray,
            uncheckedTrackColor = Color.White,
            disabledCheckedThumbColor = Color.Blue.copy(alpha = ContentAlpha.disabled),
            disabledCheckedTrackColor = Color.DarkGray.copy(alpha = ContentAlpha.disabled),
            disabledUncheckedThumbColor = Color.Gray.copy(alpha = ContentAlpha.disabled),
            disabledUncheckedTrackColor = Color.White.copy(alpha = ContentAlpha.disabled)

        )
            )

    }

}