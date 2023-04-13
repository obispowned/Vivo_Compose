package com.game.vivocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.game.vivocompose.app.model.HomeViewModel
import com.game.vivocompose.app.ui.navScreens.CentrosScreen
import com.game.vivocompose.app.ui.navScreens.InformesScreen
import com.game.vivocompose.app.ui.navScreens.MisCitasScreen
import com.game.vivocompose.app.ui.navScreens.MyHomeScreen
import com.game.vivocompose.app.navigation.*
import com.game.vivocompose.app.model.LoginViewModel
import com.game.vivocompose.app.model.SignupViewModel
import com.game.vivocompose.app.model.WelcomeViewModel
import com.game.vivocompose.ui.theme.VivoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val welcomeViewModel: WelcomeViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()
    private val signupViewModel: SignupViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VivoComposeTheme() {
                mainScreen()
            }
        }
    }

    @Composable
    private fun mainScreen() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.WelcomeNav.route
            ) {
                composable(Routes.WelcomeNav.route) {
                    WelcomeNav(
                        navigationController,
                        welcomeViewModel
                    )
                }
                composable(Routes.LoginNav.route) {
                    LoginNav(navigationController, loginViewModel)
                }
                composable(Routes.SignupNav.route) {
                    SignupNav(navigationController, signupViewModel)
                }
                composable(Routes.HomeNav.route) {
                    HomeNav(navigationController, homeViewModel)
                }
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
    }
}
