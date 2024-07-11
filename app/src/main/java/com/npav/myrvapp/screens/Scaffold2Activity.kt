package com.npav.myrvapp.screens

import android.util.Log
import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Scaffold2Activity() {

    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)

        CustomDialog(value = "", setShowDialog = { showDialog.value = it}, setValue = { Log.i("HomePage","HomePage : $it")})


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = "Sample") })

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    showDialog.value = true
                    when (scaffoldState.snackbarHostState.showSnackbar(
                        message = "This is a sample snackbar",
                        actionLabel = "Cancel"
                    )) {
                        SnackbarResult.ActionPerformed -> {

                        }

                        SnackbarResult.Dismissed -> {

                        }
                    }
                }
            },
                contentColor = Color.LightGray,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp)
                ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier
                    .width(25.dp)
                    .height(25.dp))
            }
        }
    ) {

    }



}