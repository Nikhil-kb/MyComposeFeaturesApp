package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)

@Composable
fun FlowRowComposeNew() {
    val rowItems = listOf(
        "cross",
        "axis",
        "arrangment",
        "max",
        "item",
        "alignment",
        "weights",
        "layout",
        "franction",
        "sizing",
        "basice",
        "constraint layout"
    )

    FlowColumn(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        maxItemsInEachColumn = 4,


    ) {
        rowItems.forEachIndexed { index, unit ->
            UserDefinedChipsCompose(item = unit)
        }
    }

}

