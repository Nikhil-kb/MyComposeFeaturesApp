package com.npav.myrvapp.activity.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import com.npav.myrvapp.activity.models.DrawerItemModel

object FlowDataList {

    val chipList = listOf(
        "Price: High to Low",
        "Avg rating: 4+",
        "Free breakfast",
        "Free cancellation",
        "£50 pn"
    )

    val modalDataList = listOf(
        DrawerItemModel(
            itemName = "Item1",
            selectedIcon = Icons.Filled.Place,
            unSelectedIcon = Icons.Outlined.Place,
            isSelected = true
        ),
        DrawerItemModel(
            itemName = "Item2",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings
        ),
        DrawerItemModel(
            itemName = "Item3",
            selectedIcon = Icons.Filled.Person,
            unSelectedIcon = Icons.Outlined.Person
        ),
        DrawerItemModel(
            itemName = "Item4",
            selectedIcon = Icons.Filled.Email,
            unSelectedIcon = Icons.Outlined.Email
        )
    )


}