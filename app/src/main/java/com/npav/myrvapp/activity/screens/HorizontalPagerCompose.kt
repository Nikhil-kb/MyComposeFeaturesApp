package com.npav.myrvapp.activity.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.activity.models.FeatureModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerCompose2(sampleList: List<String>, featureList: MutableList<FeatureModel>) {

    val pagerState = rememberPagerState() {
        sampleList.size
    }

    var count by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = count) {
        pagerState.animateScrollToPage(count)
        delay(1000)

        if (count == 8) {
            count = 0
        } else count++

    }

    Column() {

        HorizontalPager(state = pagerState) { index ->
            val brush = Brush.linearGradient(listOf(Color(0xFFBB86FC), Color(0xFF6200EE)))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp)

            ) {
                Box(
                    modifier = Modifier.background(brush = brush),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = sampleList[index],
                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                    )
                }

            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LazyRow() {
                items(sampleList.size) { spacerIndex ->
                    Spacer(
                        modifier = Modifier
                            .padding(2.dp)
                            .background(
                                color = if (spacerIndex == pagerState.currentPage) Color.DarkGray else Color.LightGray,
                                shape = CircleShape
                            )
                            .size(10.dp)

                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        GridLayoutCompose(featureList)

    }

}

@Composable
fun GridLayoutCompose(featureList: MutableList<FeatureModel>) {

    LazyVerticalGrid(columns = GridCells.Fixed(3)) {

        items(featureList.size) { index ->
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = featureList[index].featureIconId),
                        contentDescription = featureList[index].featureName,
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = featureList[index].featureName,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                }
            }
        }

    }

}