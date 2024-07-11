package com.npav.myrvapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun VerticalPagerCompose() {

    val pagerState = rememberPagerState(pageCount = { 10 })
    val brush = Brush.linearGradient(listOf(Color.Red, Color.LightGray, Color.Gray))

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(200.dp)
    ) {

            page ->
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
        ) {
            Text(
                text = "Page $page",
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            )
        }

    }

}