package com.npav.myrvapp.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.R
import com.npav.myrvapp.compose.ui.theme.MyRVAppTheme
import com.npav.myrvapp.model.UserData
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailsContent()
           //composeButton("sample", onChangeClick = { "67890" })
            /*   MyRVAppTheme {
                   // A surface container using the 'background' color from the theme
                   Surface(
                       modifier = Modifier.fillMaxSize(),
                       color = MaterialTheme.colors.background
                   ) {
                       Greeting("Android")
                   }
               }*/
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewCompose() {
    composeView(UserData("name","nationality",18, "details","healthState", true, R.drawable.ic_launcher_foreground))
    //composeText("Sample string")
    //composeImgaeView()
    /*MyRVAppTheme {
        Greeting("Android")
    }*/
}


@Composable
fun composeView(userData: UserData) {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
       elevation = 4.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row(modifier = Modifier.padding(10.dp)) {

            Image(
                /*modifier = Modifier.weight(2f, fill = false).aspectRatio(),*/
                painter = painterResource(id = userData.imageId),
                contentDescription = "Sample compose image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.weight(0.35f).padding(8.dp).size(60.dp).clip(CircleShape)
            )

            Column(
                modifier = Modifier.weight(0.65f),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = userData.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 2.sp
                )

                Text(
                    text = "Nationality: "+userData.nationality,
                    style = TextStyle(color = Color.Black, fontSize = 15.sp)
                )

                Text(
                    text = "Age: "+userData.age,
                    style = TextStyle(color = Color.Black, fontSize = 15.sp)
                )

                Text(
                    text = "Health state: "+userData.healthState,
                    style = TextStyle(color = Color.Black, fontSize = 15.sp)
                )

                Text(
                    text = "Details: "+userData.details,
                    style = TextStyle(color = Color.Black, fontSize = 15.sp)
                )

            }

        }
    }


}

@Composable
fun composeText(strValue: String) {
    Text(
        text = "Compose string : $strValue",
        color = Color.Red,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp,
        letterSpacing = 2.sp,
        textAlign = TextAlign.Center,
        maxLines = 1,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    println("on press")
                },
                onTap = {
                    println("on tap")
                },
                onDoubleTap = {
                    println("on double tap")
                },
                onLongPress = {
                    println("on long press")
                }
            )
        }
    )

}

@Composable
fun composeButton(strValue1: String, onChangeClick: () -> String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var state = remember {
            mutableStateOf("12345")
        }

        Text(
            text = "Compose string : ${state.value}",
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        println("on press")
                    },
                    onTap = {
                        println("on tap")
                    },
                    onDoubleTap = {
                        println("on double tap")
                    },
                    onLongPress = {
                        println("on long press")
                    }
                )
            }
        )

        Button(onClick = {
            state.value = onChangeClick().toString()
        }) {
            Text(text = "Sample button")
        }
    }
}

@Composable
fun composeImgaeView() {
    Image(
        /*modifier = Modifier.weight(2f, fill = false).aspectRatio(),*/
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Sample compose image",
        colorFilter = ColorFilter.tint(Color.Green),
        contentScale = ContentScale.Crop
    )
}

object Details {
    val userDataList = listOf(
        UserData("Thomas Lincaster", "American", 38, "Web developer", "Fit", true, R.drawable.american_map),
        UserData("Edward Smith", "Canadian", 32, "Web developer", "Fit", true,R.drawable.americans),
        UserData("Sasha Kelly", "Irish", 24, "Web developer", "Fit", true,R.drawable.chinese_map),
        UserData("Amber Heard", "British", 29, "Web developer", "Fit", true, R.drawable.chinese_map),
        UserData("Joshua Boboi", "Ghana", 31, "Web developer", "Fit", true, R.drawable.japanese_woman),
    )
}

@Composable
fun DetailsContent() {

    val userData = remember { Details.userDataList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            userData
        ) {
            composeView(userData = it)
        }
    }
}


