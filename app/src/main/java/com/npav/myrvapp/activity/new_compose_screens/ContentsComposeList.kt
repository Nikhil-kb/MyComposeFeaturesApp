package com.npav.myrvapp.activity.new_compose_screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.npav.myrvapp.activity.models.ContentModel

@Composable
fun ContentsComposeList(contentList: List<ContentModel>) {

    var selectedIndex by remember{
        mutableStateOf(-1)
    }


    if(selectedIndex != -1){
        ContentDetails(
            title = contentList[selectedIndex].title,
            content = contentList[selectedIndex].content,
            backColor = contentList[selectedIndex].backColor,
            actionIcon = contentList[selectedIndex].actionIcon
        )
    }

    LazyColumn(){
        items(contentList.size) { index ->
            ColumnCompose(
                title = contentList[index].title,
            content = contentList[index].content,
            backColor = contentList[index].backColor,
            actionIcon = contentList[index].actionIcon
            ) {
                selectedIndex = index
            }
        }
    }


}