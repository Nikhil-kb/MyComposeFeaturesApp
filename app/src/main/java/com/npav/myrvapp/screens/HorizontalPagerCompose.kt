package com.npav.myrvapp.screens

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.activity.PageData
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.absoluteValue

@ExperimentalFoundationApi
@Composable
fun HPContainerCompose() {

    val pageList = listOf(
        PageData(Color.LightGray, "androidx.compose.foundation.pager.rememberPagerState"),
        PageData(Color.DarkGray, "androidx.compose.foundation.pager.HorizontalPager"),
        PageData(Color.Red, "androidx.compose.foundation.ExperimentalFoundationApi"),
        PageData(Color.Green, "androidx.compose.foundation.layout.fillMaxWidth")
    )

    var currentPage by remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState(pageCount = { pageList.size })
    val corountineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.height(250.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPagerCompose(pageList, pagerState)

            Button(onClick = {
                corountineScope.launch {
                    if (currentPage == pageList.size) {
                        currentPage = 0
                    } else {
                        currentPage++
                    }
                    pagerState.animateScrollToPage(currentPage)
                }
            }) {
                Text(text = "Scroll")
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {

            repeat(pageList.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color = color)
                        .size(18.dp)
                )
            }

        }


    }

}

@ExperimentalFoundationApi
@Composable
fun HorizontalPagerCompose(pageList: List<PageData>, pagerState: PagerState) {


    VerticalPager(
        state = pagerState, modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) { page ->
        val brush = Brush.linearGradient(listOf(pageList[page].color, Color.Blue))
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .height(180.dp)
                .padding(horizontal = 35.dp, vertical = 25.dp)
                /*.graphicsLayer {
                // Calculate the absolute offset for the current page from the
                // scroll position. We use the absolute value which allows us to mirror
                // any effects for both directions
                val pageOffset = (
                        (pagerState.currentPage - page) + pagerState
                            .currentPageOffsetFraction
                        ).absoluteValue

                // We animate the alpha, between 50% and 100%
                alpha = lerp( start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f))


            }*/
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.background(brush = brush)
            ) {

                Text(
                    text = pageList[page].content,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    ),
                    modifier = Modifier.padding(horizontal = 15.dp)
                )

            }

        }

    }

}