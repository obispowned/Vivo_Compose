package com.game.vivocompose.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItem(val route:String, val title:String, val icon:ImageVector){

    object Home : BottomNavItem("home", "Home", Icons.Default.Apps)
    object MisCitas: BottomNavItem("mis_citas", "Mis Citas", Icons.Default.CalendarToday)
    object Centros: BottomNavItem("centros", "Centros", Icons.Default.LocationOn)
    object Informes: BottomNavItem("informes","Informes",Icons.Default.Description)

}