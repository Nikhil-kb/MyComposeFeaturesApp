package com.npav.myrvapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.npav.myrvapp.screens.*
import com.npav.myrvapp.ui.theme.MyRVAppTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRVAppTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnnotatedClickableText()
                    //InteractionSourceCompose()
                    //CheckBoxCompose()
                    //HomePage()
                    //Dialog(value = "", setShowDialog = {true}, setValue = {"Dialog opened"})
                    //Scaffold2Activity()
                    //Scaffold1()
                    // Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "URL", annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue, fontWeight = FontWeight.Bold
            )
        ) {
            append("here")
        }

        pop()
    }

    ClickableText(text = annotatedText, onClick = { offset ->
        // We check if there is an *URL* annotation attached to the text
        // at the clicked position
        annotatedText.getStringAnnotations(
            tag = "URL", start = offset, end = offset
        ).firstOrNull()?.let { annotation ->
            // If yes, we log its value
            Log.d("Clicked URL", annotation.item)
        }
    })
}

@Composable
fun InteractionSourceCompose() {
    val interactionSource = remember{
        MutableInteractionSource()
    }
    
    val isPressed = interactionSource.collectIsPressedAsState()
    
    val interactionState = remember{
        mutableStateListOf<Interaction>()
    }

    LaunchedEffect(interactionSource){
        interactionSource.interactions.collect(){
            interaction -> when(interaction){
                is PressInteraction.Press -> {
                    interactionState.add(interaction)
                }

                is DragInteraction.Start -> {
                    interactionState.add(interaction)
                }
            }
        }
    }

    Surface {
        Box(modifier = Modifier.clickable {  },
        contentAlignment = Alignment.Center
            ){
            Button(onClick = { },
            interactionSource = interactionSource
                ) {
                Text(if(isPressed.value) "Pressed" else "Not pressed")
            }
        }

    }

}

@Composable
fun HomePage(){

    var red by remember { mutableStateOf(0f) }
    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)

        CustomDialog(value = "", setShowDialog = { showDialog.value = it}, setValue = { Log.i("HomePage","HomePage : $it")})

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                }
            )
        }) {
        Box(modifier = Modifier.background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

              /*  Slider(
                    value = red,
                    onValueChange = { red = it },
                    valueRange = 0f..255f,
                    onValueChangeFinished = {}
                )*/

                Button(onClick = {
                    showDialog.value = true
                }) {
                    Text(text = "Open Dialog")
                }
            }
        }
    }
}

@Composable
fun Scaffold1() {

    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(

        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                onMenuClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        bottomBar = {
            BottomBar()
        },
        content = { Body() },
        drawerContent = { Drawer() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    when(scaffoldState.snackbarHostState.showSnackbar(
                        message = "Sample snack bar message", actionLabel = "Dismiss"
                    )){
                        SnackbarResult.Dismissed -> {

                        }

                        SnackbarResult.ActionPerformed -> {

                        }
                    }
                }
            },
            ) {
                Text(text = "Fab")
            }
        }

        )


}


/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRVAppTheme {
        Greeting("Android")
    }
}*/
