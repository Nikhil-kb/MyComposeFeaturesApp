package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.npav.myrvapp.activity.models.GridFeaturesModel
import com.npav.myrvapp.activity.models.MessageData
import com.npav.myrvapp.activity.models.WAFeaturesCompose
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun ChatCompose(msgDataList: ArrayList<MessageData>, featureList: List<GridFeaturesModel>) {

    val coroutineScope = rememberCoroutineScope()

    val messageDataList = remember {
        mutableStateListOf<MessageData>()
    }

    var message by remember {
        mutableStateOf("")
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    var clickState by remember{
        mutableStateOf(false)
    }

    val modalBottomSheetState = ModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.Expanded })


    LaunchedEffect(key1 = true) {
        if (messageDataList.size > 0) {
            messageDataList.clear()
        }
        messageDataList.addAll(msgDataList)
    }


    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetContent = {
            WAFeaturesCompose(
                featureList = featureList,
                onDissmissRequest = {
                    showDialog = it
                })
        }) {


        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            val listState = rememberLazyListState()

            // Message list
            LazyColumn(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 18.dp)
                    .weight(1f),
                state = listState,
            ) {
                itemsIndexed(messageDataList) { index, item ->
                    MessageCompose(item)
                }
            }

            Row() {

                //Text field to type message
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 4.dp, start = 5.dp, end = 5.dp),
                    value = if(clickState) "" else message,
                    onValueChange = {
                        message = it
                        clickState = false
                    },
                    placeholder = {
                        Text(text = "Enter message here")
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Outlined.Info,
                            contentDescription = "Open dialog",
                            modifier = Modifier.clickable {
                                //showDialog = true

                                coroutineScope.launch {
                                    if(modalBottomSheetState.isVisible){
                                        modalBottomSheetState.hide()
                                    }else{
                                        modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                                    }
                                }

                            }
                        )
                    }
                )

                // Send message button
                IconButton(onClick = {
                    clickState = true
                    val msg = message
                    messageDataList.add(MessageData("Sample userName", msg))
                    coroutineScope.launch {
                        listState.animateScrollToItem(messageDataList.lastIndex)
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "Send Message"
                    )
                }
            }
        }

    }

}

private fun <T> SnapshotStateList<T>.swapList(newList: List<T>) {
    if (size > 0) {
        clear()
    }
    addAll(newList)
}



