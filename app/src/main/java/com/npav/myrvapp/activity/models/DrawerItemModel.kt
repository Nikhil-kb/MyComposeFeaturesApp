package com.npav.myrvapp.activity.models

import androidx.compose.material.BottomDrawerValue
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItemModel(
    val itemName: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val isSelected: Boolean = false
    )