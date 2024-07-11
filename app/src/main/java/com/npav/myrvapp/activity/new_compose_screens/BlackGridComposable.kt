package com.npav.myrvapp.activity.new_compose_screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.npav.myrvapp.activity.models.GridModel

val gridList = listOf(
    GridModel("title1", Icons.Filled.AccountBox),
    GridModel("title2", Icons.Filled.Menu),
    GridModel("title3", Icons.Filled.Refresh),
    GridModel("title4", Icons.Filled.Favorite),
    GridModel("title5", Icons.Filled.CheckCircle),
    GridModel("title6", Icons.Filled.Build),
    GridModel("title7", Icons.Filled.Call),
    GridModel("title8", Icons.Filled.Email),
    GridModel("title9", Icons.Filled.Person),
    GridModel("title10", Icons.Filled.Place)
)

@Composable
fun BlackGridComposable() {


    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 15.dp),
        elevation = 5.dp
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(gridList.size) { index ->
                Box(
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    gridList[index].title,
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                        .size(55.dp)
                        .padding(8.dp)
                        .background(color = Color.Black, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = gridList[index].icon,
                        contentDescription = gridList[index].title,
                        tint = Color.White
                    )
                }
            }
        }

    }


}