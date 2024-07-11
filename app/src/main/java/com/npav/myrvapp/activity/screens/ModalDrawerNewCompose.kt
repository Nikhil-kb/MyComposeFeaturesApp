package com.npav.myrvapp.activity.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.activity.util.FlowDataList
import kotlinx.coroutines.launch

@Composable
fun ModalDrawerNewCompose() {

    val modalDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed);
    val coroutineScope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = modalDrawerState,
        drawerContent = {
            ModalDrawerContentCompose(modalDrawerState)
        }) {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(color = Color.White)
                ) {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Icon(imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",

                                modifier = Modifier
                                    .size(30.dp)
                                    .clickable {
                                        coroutineScope.launch { modalDrawerState.open() }
                                    }
                            )
                        }
                    }
                }
            }
        ) {

        }
    }

}


@Composable
fun ModalDrawerContentCompose(modalDrawerState: DrawerState) {

    var selectedItem by remember {
        mutableStateOf(0)
    }
    val coroutineScope = rememberCoroutineScope()



    NavigationRail() {

        FlowDataList.modalDataList.forEachIndexed() { index, drawerItemModel ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        selectedItem = index
                    }.padding(vertical = 3.dp, horizontal = 4.dp),
                elevation = if(index == selectedItem) 5.dp else 0.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = drawerItemModel.itemName,
                        style = TextStyle(
                            color = if (index == selectedItem) Color.Black else Color.DarkGray,
                            fontSize = 20.sp
                        )
                    )

                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                            },
                        imageVector = if (index == selectedItem) drawerItemModel.selectedIcon else drawerItemModel.unSelectedIcon,
                        contentDescription = drawerItemModel.itemName
                    )

                }
            }


        }
    }
}