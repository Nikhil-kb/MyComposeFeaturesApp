package com.npav.myrvapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.rememberNavController
import com.npav.myrvapp.R
import com.npav.myrvapp.activity.screens.DatePickerDialog_
import com.npav.myrvapp.activity.screens.TimePickerDialog_
import com.npav.myrvapp.activity.sealed.DrawerSealed
import com.npav.myrvapp.activity.ui.theme.MyRVAppTheme
import com.npav.myrvapp.activity.ui.theme.Shapes
import com.npav.myrvapp.activity.ui.theme.Teal200
import com.npav.myrvapp.model.ListItem
import com.npav.myrvapp.model.SampleData
import com.npav.myrvapp.screens.Body
import com.npav.myrvapp.screens.BottomBar
import com.npav.myrvapp.ui.theme.LightGray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@ExperimentalMaterialApi
class TfComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val composeViewModel by viewModels<ComposeViewModel>()
            val viewModel: SampleViewModel by viewModels()
            MyRVAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var seconds by remember {
                        mutableStateOf(3)
                    }
                    var sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
                    val coroutineScope = rememberCoroutineScope()

                    LaunchedEffect(key1 = true) {
                        while (seconds > 0) {
                            seconds--
                            delay(1000)
                        }
                    }

                    if (seconds == 0) {

                        MainScaffold(composeViewModel, sheetState = sheetState)
                        //MultipleSelectListItems()
                    } else {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(60.dp))
                        }

                    }


                    /* Box(modifier = Modifier.fillMaxSize(),
                         contentAlignment = Alignment.Center
                         ){
                         Column(
                             modifier = Modifier.fillMaxSize()
                             , verticalArrangement = Arrangement.SpaceBetween) {
                             LinearProgressIndicator()

                             LinearProgressIndicator(progress = 0.67f)

                             CircularProgressIndicator()

                             CircularProgressIndicator(progress = 0.43f)
                         }

                     }*/

                    /*Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        // TextShadow()
                        //TFCompose(viewModel)
                        //SelectionContainerText()
                        //ClickableTextComp()
                        //ImageCompose()

                    }*/

                    /*  var items by remember {
                          mutableStateOf(
                              (1..20).map {
                                  ListItem(
                                      title = "Item $it",
                                      isSelected = false
                                  )
                              }
                          )
                      }

                     var selectedItem by remember{
                         mutableStateOf(-1)
                     }

                      LazyColumn() {

                          items(items.size) {
                                  firstIndex ->
                              Row(
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .clickable {
                                          selectedItem = firstIndex
                                          *//*items = items.mapIndexed { secondIndex, item ->
                                             if (firstIndex == secondIndex) {
                                                 item.copy(isSelected = !item.isSelected)
                                             } else item
                                         }*//*
                                     }
                                     .padding(10.dp),
                                 horizontalArrangement = Arrangement.SpaceBetween,
                                 verticalAlignment = Alignment.CenterVertically
                             ) {

                                 Text(text = items[firstIndex].title, color = Color.Black, fontSize = 18.sp)
                                 if (selectedItem == firstIndex) {
                                     Icon(
                                         imageVector = Icons.Filled.CheckCircle,
                                         contentDescription = "Selected",
                                         modifier = Modifier.size(24.dp),
                                         tint = Color.Black
                                     )
                                 }

                             }
                         }

                     }
*/
                    /*  var selectedItem by remember{
                          mutableStateOf(-1)
                      }
                      val onItemClick = { index: Int ->
                          selectedItem = index
                      }

                      LazyColumn(){
                          items(100){
                              index -> SelectableText(index = index, isSelected = selectedItem == index, onClick = onItemClick)
                          }
                      }*/


                }
            }
        }
    }
}

private val screens = listOf(
    DrawerSealed.Home,
    DrawerSealed.Account,
    DrawerSealed.Help
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.americans),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked()
                }
            )
        }
    }
}

@Composable
fun AppMainScreen() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerOpen = scope.launch {
        drawerState.open()
    }

/*    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            Drawer(onDestinationClicked = {
                    route ->

                scope.launch {
                    drawerState.close()
                }

                navController.navigate(route){
                    popUpToRoute = navController.graph.startDestinationRoute,
                    launchSingleTop = true
                }

            })
        },


    ) {

    }*/

}


@ExperimentalMaterialApi
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScaffold(composeViewModel: ComposeViewModel, sheetState: ModalBottomSheetState) {

    var state = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var composeState by remember {
        mutableStateOf(0)
    }


    Scaffold(
        scaffoldState = state,
        topBar = { TobAppBar() },
        bottomBar = {
            BottomAppBar(composeViewModel) {
                composeState = composeViewModel.stateFlow.value
            }
        },
        drawerContent = {
            DrawerCompose()
        }
    ) {

        if (composeState == 4) {

            BottomSheetComposable(sheetState = sheetState, coroutineScope = coroutineScope)

        } else if (composeState == 2) {
            DatePickerDialog_(context = LocalContext.current)
        } else if (composeState == 3) {
            TimePickerDialog_(context = LocalContext.current)
        } else if (composeState == 0) {
            MultipleSelectListItems()
        }

    }

}

@ExperimentalMaterialApi
@Composable
fun BottomSheetComposable(sheetState: ModalBottomSheetState, coroutineScope: CoroutineScope) {
    ModalBottomSheetLayout(sheetContent = {
        Text("Click1")
        Text("Click2")
        Text("Click3")
        Text("Click4")
        Text("Click5")
        Text("Click6")

    },
        sheetState = sheetState,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {

    }

}

@Composable
fun DrawerCompose() {

    Column(horizontalAlignment = Alignment.Start) {

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.background(color = Teal200)
        ) {
            Image(
                painter = painterResource(id = R.drawable.americans),
                contentDescription = "American Profile",
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = CircleShape)
                    .padding(vertical = 20.dp, horizontal = 15.dp)
            )

            Text(
                text = "Thomas Lincaster",
                style = TextStyle(color = Color.Black, fontSize = 18.sp),
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Text(
                text = "Email: abca@gmail.com",
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Text(
                text = "Phone: 9876543210",
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 15.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(horizontalAlignment = Alignment.Start) {

            Text(
                text = "Settings",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(horizontal = 15.dp)
            )

            Text(
                text = "Email setting",
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 18.dp)
            )

            Text(
                text = "Mobile setting",
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 18.dp)
            )

        }

    }

}

@Composable
fun TobAppBar() {

    Card(elevation = 4.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 10.dp),
                text = "AppTileDemo",
                style = TextStyle(
                    color = Color.Black, fontSize = 25.sp,
                    fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold
                )
            )

            Row(
                modifier = Modifier.padding(end = 15.dp, top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite, contentDescription = "Favorite",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 8.dp, end = 4.dp)
                )
                Icon(
                    imageVector = Icons.Default.Favorite, contentDescription = "Favorite",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 4.dp, end = 8.dp)
                )
            }

        }
    }

}

@Composable
fun BottomAppBar(composeViewModel: ComposeViewModel, onClickIcon: () -> Unit) {

    val scope = rememberCoroutineScope()

    Card(elevation = 2.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "Favorite",
                modifier = Modifier
                    .clickable {
                        scope.launch {
                            composeViewModel.updateStateFlow(0)
                            onClickIcon()
                        }
                    }
                    .size(32.dp)
            )

            Icon(
                imageVector = Icons.Default.Search, contentDescription = "Favorite",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        scope.launch {
                            composeViewModel.updateStateFlow(2)
                            onClickIcon()
                        }
                    }
            )

            Icon(
                imageVector = Icons.Default.Refresh, contentDescription = "Favorite",
                modifier = Modifier
                    .clickable {
                        scope.launch {
                            composeViewModel.updateStateFlow(3)
                            onClickIcon()
                        }
                    }
                    .size(32.dp)
            )

            Icon(
                imageVector = Icons.Default.Menu, contentDescription = "Menu",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        scope.launch {
                            composeViewModel.updateStateFlow(4)
                            onClickIcon()
                        }
                    }
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MultipleSelectListItems() {

    var ListItems by remember {
        mutableStateOf(
            (0..30).map {
                ListItem(
                    title = "Item $it",
                    isSelected = false
                )
            }
        )
    }

    var gridItems by remember {
        mutableStateOf(
            listOf(
                SampleData(
                    "Add",
                    "This is sample description 1",
                    Icons.Default.Add,
                    LightGray
                ),
                SampleData(
                    "Show",
                    "This is sample description 2",
                    Icons.Default.Search,
                    LightGray
                ),
                SampleData(
                    "Edit",
                    "This is sample description 3",
                    Icons.Default.Edit,
                    LightGray
                ),
                SampleData(
                    "Delete",
                    "This is sample description 4",
                    Icons.Default.Delete,
                    LightGray
                )
            )
        )
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 25.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            items(gridItems.size) { index ->
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(color = gridItems[index].colorCode)
                        .clickable {
                            gridItems = gridItems.mapIndexed { secondIndex, item ->
                                if (index == secondIndex) {
                                    item.copy(title = "New SampleTitle")
                                } else item

                            }
                        }
                ) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(shape = CircleShape)
                                .padding(2.dp),
                            imageVector = gridItems[index].imageId,
                            contentDescription = "Sample Images"
                        )

                        Spacer(modifier = Modifier.size(12.dp))

                        Column(

                        ) {

                            Text(text = gridItems[index].title, fontSize = 18.sp)
                            Text(text = gridItems[index].details, fontSize = 16.sp)
                        }

                    }


                }
            }
        }


        Text(
            text = "List of items",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 22.dp, top = 10.dp),
            contentAlignment = Alignment.Center,
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {


                items(ListItems.size) { index ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp, top = 1.dp, bottom = 3.dp),
                        elevation = 1.dp,
                        contentColor = Color.LightGray,
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    ListItems = ListItems.mapIndexed { secondIndex, item ->
                                        if (index == secondIndex) {
                                            item.copy(isSelected = !ListItems[index].isSelected)
                                        } else item
                                    }
                                }
                                .padding(2.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp, horizontal = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                SelectionContainer() {
                                    Text(
                                        text = "Name of the item: ${ListItems[index].title}",
                                        style = TextStyle(color = Color.Black, fontSize = 18.sp)
                                    )
                                }

                                if (ListItems[index].isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Selected item"
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }

    }


}


@Composable
fun SelectableText(index: Int, isSelected: Boolean, onClick: (Int) -> Unit) {

    Text(text = "Item $index",
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke(index) }
            .background(
                color = if (isSelected) {
                    Color.Red
                } else {
                    Color.Transparent
                }
            )
            .padding(12.dp)
    )

}

@Composable
fun ImageCompose() {

    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(width = 1.dp, color = Color.Green))
        .background(color = Color.Yellow)
    Image(
        painter = painterResource(id = R.drawable.american_map),
        contentDescription = "American map",
        contentScale = ContentScale.Fit,
        modifier = imageModifier
    )

}

@Composable
fun ClickableTextComp() {

    val annotatedString = buildAnnotatedString {
        append("Click ")
        pushStringAnnotation(tag = "URL", annotation = "https://developer.android.com")
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
            append("Here")
        }
        pop()
    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
            .firstOrNull()?.let { annotation ->
                Log.d("Clicked URL", annotation.item)
            }
    })


}

@Composable
fun SelectionContainerText() {

    SelectionContainer() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "This is a sample sentence 1")
            Text(text = "This is a sample sentence 2")
            Text(text = "This is a sample sentence 3")

            DisableSelection {
                Text(text = "This is a sample sentence 4")
            }

            Text(text = "This is a sample sentence 5")
            Text(text = "This is a sample sentence 6")
        }


    }
}

class SampleViewModel : ViewModel() {
    var textfState by mutableStateOf("")

    fun updateTextFState(stateName: String) {
        textfState = stateName
    }
}

@Composable
fun TFCompose(viewModel: SampleViewModel) {

    var tfState by rememberSaveable {
        mutableStateOf("")
    }

    val maxChar = 7

    var toggleValue by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = toggleValue) {
        println("tfState: $tfState")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        value = viewModel.textfState,
        onValueChange = { newText ->
            if (newText.length <= maxChar) tfState = newText.trimStart { it == '0' }
            viewModel.updateTextFState(tfState)
            toggleValue = !toggleValue
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(
            color = Color.Blue,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic
        ),
        label = {
            Text(text = "Enter password", color = Color.Red)
        },
        maxLines = 1,
    )


}


@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun Greeting(name: String) {
    var tfState = remember {
        mutableStateOf("")
    }

    val brush = remember {
        Brush.linearGradient(
            colors = listOf(
                Color(0xffF57F17),
                Color(0xFFF1DF3D),
                Color(0xFFD6D3BA)
            )
        )
    }


    var clickState = remember {
        mutableStateOf(false)
    }

    var navIconState = rememberCoroutineScope()


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back arrow",
                        modifier = Modifier.clickable {
                            clickState.value = true
                        }
                    )
                    Text(
                        text = "TFCompose",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "delete")
                }
            }
        }
    ) {

        var imgClickState = remember {
            mutableStateOf(false)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconToggleButton(
                checked = imgClickState.value,
                onCheckedChange = { imgClickState.value = !imgClickState.value },
                modifier = Modifier.padding(10.dp)
            ) {

                var transition = updateTransition(targetState = imgClickState.value)

                val tint by transition.animateColor(label = "iconColor") { isChecked ->
                    if (isChecked) Color.Red else Color.Black
                }

                val size by transition.animateDp(
                    transitionSpec = {
                        if (false isTransitioningTo true) {
                            keyframes {
                                durationMillis = 250
                                30.dp at 0 with LinearOutSlowInEasing
                                35.dp at 15 with FastOutLinearInEasing
                                40.dp at 75
                                35.dp at 150
                            }
                        } else {
                            spring(stiffness = Spring.StiffnessVeryLow)
                        }
                    },
                    label = "Size"
                ) { 30.dp }

                Icon(
                    imageVector = if (imgClickState.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = tint/*,
                modifier = Modifier.size(size)*/
                )

            }
        }

        if (clickState.value) {
            Body()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = tfState.value,
                    maxLines = 1,
                    onValueChange = {
                        tfState.value = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Red
                    ),
                    label = { Text(text = "Enter your name") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    },
                    textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRVAppTheme {
        Greeting("Android")
    }
}