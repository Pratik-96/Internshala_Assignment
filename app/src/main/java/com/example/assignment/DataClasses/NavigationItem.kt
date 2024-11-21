package com.example.assignment.DataClasses

import android.media.Image
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title:String,
    val selectedIcon : ImageVector,
    val route : String
)
