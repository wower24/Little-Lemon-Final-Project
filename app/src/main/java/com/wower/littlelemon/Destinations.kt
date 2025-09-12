package com.wower.littlelemon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route :String
    val icon :ImageVector
    val title :String
}

object Home :Destinations {
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}

object Profile: Destinations {
    override val route = "Profile"
    override val icon = Icons.Filled.AccountBox
    override val title = "Profile"
}

object Onboarding: Destinations {
    override val route = "Onboarding"
    override val icon = Icons.Filled.Info
    override val title = "Onboarding"
}