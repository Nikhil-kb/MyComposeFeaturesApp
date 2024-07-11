package com.npav.myrvapp.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.R
import com.npav.myrvapp.compose.ui.theme.MyRVAppTheme
import com.npav.myrvapp.model.UserData

class ScomposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //generateList()
            MyRVAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    generateList()
                    // Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun composeList(userData: UserData) {

    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 4.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {

        Row(modifier = Modifier.padding(8.dp)) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(0.70f)
            ) {

                Text(
                    text = "Name: " + userData.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    letterSpacing = 2.sp
                )

                Text(
                    text = "Nationality: " + userData.nationality,
                    style = TextStyle(color = Color.Black, fontSize = 18.sp)
                )

                Text(
                    text = "HealthState: " + userData.healthState,
                    style = TextStyle(color = Color.Black, fontSize = 18.sp)
                )

                Text(
                    text = "Details: " + userData.details,
                    style = TextStyle(color = Color.Black, fontSize = 18.sp)
                )

            }

            Box(modifier = Modifier.weight(0.30f)){
                Image(
                    painter = painterResource(id = userData.imageId),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .clip(CircleShape)
                )
                Icon(Icons.Filled.Check, contentDescription = "Check mark")
            }





        }

    }

}

object UserDataObject {
    val userDataList = listOf(
        UserData(
            "Thomas Lincaster",
            "American",
            38,
            "Web developer",
            "Fit",
            true,
            R.drawable.american_map
        ),
        UserData(
            "Edward Smith",
            "Canadian",
            32,
            "Web developer",
            "Fit",
            true,
            R.drawable.americans
        ),
        UserData("Sasha Kelly", "Irish", 24, "Web developer", "Fit", true, R.drawable.chinese_map),
        UserData(
            "Amber Heard",
            "British",
            29,
            "Web developer",
            "Fit",
            true,
            R.drawable.chinese_map
        ),
        UserData(
            "Joshua Boboi",
            "Ghana",
            31,
            "Web developer",
            "Fit",
            true,
            R.drawable.japanese_woman
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun generateList() {
    val userDataState = remember {
        UserDataObject.userDataList
    }

    LazyColumn(
        modifier = Modifier.padding(top=50.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(userDataState) {
            composeList(userData = it)
        }
    }

}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRVAppTheme {
        // Greeting("Android")
    }
}*/
