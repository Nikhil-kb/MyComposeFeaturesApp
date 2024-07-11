package com.npav.myrvapp.activity.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun WAFeaturesCompose(featureList: List<GridFeaturesModel>, onDissmissRequest: (Boolean) -> Unit) {

    Surface() {

        Box(
            modifier = Modifier,
            contentAlignment = Alignment.BottomCenter
        ) {

                LazyVerticalGrid(

                    columns = GridCells.Fixed(3)
                ) {
                    itemsIndexed(featureList) { index, item ->
                        GridCell(gridFeaturesModel = item)
                    }
                }

        }
    }
}

@Composable
fun GridCell(gridFeaturesModel: GridFeaturesModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {

        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = gridFeaturesModel.color)
                .size(80.dp)
                .padding(2.dp)

            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = gridFeaturesModel.image,
                contentDescription = gridFeaturesModel.title,
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = gridFeaturesModel.title
        )

    }

}