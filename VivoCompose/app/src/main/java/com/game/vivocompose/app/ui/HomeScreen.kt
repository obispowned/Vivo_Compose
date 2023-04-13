package com.game.vivocompose.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.game.vivocompose.app.model.HomeViewModel
import com.game.vivocompose.app.navigation.BottomNavItem
import com.game.vivocompose.app.ui.navScreens.CentrosScreen
import com.game.vivocompose.app.ui.navScreens.InformesScreen
import com.game.vivocompose.app.ui.navScreens.MisCitasScreen
import com.game.vivocompose.app.ui.navScreens.MyHomeScreen
import com.game.vivocompose.R

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MisCitas,
        BottomNavItem.Centros,
        BottomNavItem.Informes
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(colorResource(id = R.color.gradient_white), colorResource(id = R.color.gradient_grey))
                )
            )
    ) {
        val navControllerr = rememberNavController()
        Scaffold(Modifier.padding(10.dp),
            bottomBar = { MyBottomNavigation(navControllerr, items) },
            floatingActionButton = { Fab() },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true //estomete el floatbutton dentro de la bottomBar

        ) {
            NavigationGraph(navController = navControllerr)
        }
    }

}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            MyHomeScreen()
        }
        composable(BottomNavItem.MisCitas.route) {
            MisCitasScreen()
        }
        composable(BottomNavItem.Centros.route) {
            CentrosScreen()
        }
        composable(BottomNavItem.Informes.route) {
            InformesScreen()
        }
    }
}

@Composable
fun Fab() {
    FloatingActionButton(
        modifier = Modifier.border(
            border = BorderStroke(3.dp, Color.White),
            shape = RoundedCornerShape(50.dp)
        ),
        onClick = { }, backgroundColor = colorResource(
            id = R.color.color_primary2
        ), contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Default.Sms, contentDescription = "add")

    }
}

@Composable
fun MyBottomNavigation(navController: NavController, items: List<BottomNavItem>) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(item.title, fontSize = 9.sp) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true //si el usuario pulsa de manera continua no crea una pila gigante
                        restoreState = true
                    }
                })
        }

    }
}