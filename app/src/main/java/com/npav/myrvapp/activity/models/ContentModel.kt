package com.npav.myrvapp.activity.models

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ContentModel(val title: String,
                        val content: String,
                        val backColor: Color,
                        val actionIcon: ImageVector)
