package com.npav.myrvapp.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.npav.myrvapp.activity.util.FlowDataList


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowCompose() {

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner) {

        val observer = LifecycleEventObserver { source, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                Log.e("Inside : ", "onPause()")
            }

            if (event == Lifecycle.Event.ON_RESUME) {
                Log.e("Inside : ", "onResume()")
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }

    }


    FlowRow(
        maxItemsInEachRow = 2
    ) {

        var prevIndex by remember {
            mutableStateOf(-1)
        }

        LazyColumn() {

            items(FlowDataList.chipList.size){
                    index ->
                ChipItem(FlowDataList.chipList[index],
                    if(index == prevIndex) Color.Red else Color.Gray
                ) {
                    prevIndex = index
                }
            }

        }

        LazyColumn() {

            items(FlowDataList.chipList.size){
                    index ->
                ChipItem(FlowDataList.chipList[index],
                    if(index == prevIndex) Color.Red else Color.Gray
                ) {
                    prevIndex = index
                }
            }

        }

    }

}

@Composable
fun ChipItem(itemStr: String, color: Color, onClick: ()->Unit) {

    var prevPostion by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .padding(2.dp)
            .border(
                width = 1.dp, color = color,
                shape = RoundedCornerShape(50.dp)
            ).clickable { onClick }
        ,
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = itemStr,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )

    }
}

