package com.game.vivocompose.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.game.vivocompose.Home.HomeScreen
import com.game.vivocompose.app.model.HomeViewModel
import com.game.vivocompose.app.model.LoginViewModel
import com.game.vivocompose.app.model.SignupViewModel
import com.game.vivocompose.app.model.WelcomeViewModel
import com.game.vivocompose.app.ui.LoginScreen
import com.game.vivocompose.app.ui.SignupScreen
import com.game.vivocompose.app.ui.WelcomeScreen

@Composable
fun WelcomeNav(navController: NavHostController, welcomeViewModel: WelcomeViewModel){
    WelcomeScreen(navController, welcomeViewModel)

}

@Composable
fun LoginNav(navController: NavHostController, loginViewModel: LoginViewModel){
    LoginScreen(navController, loginViewModel)
}

@Composable
fun SignupNav(navController: NavHostController, signupViewModel: SignupViewModel){
    SignupScreen(navController, signupViewModel)
}

@Composable
fun HomeNav(navController: NavHostController, homeViewModel: HomeViewModel){
    HomeScreen(navController, homeViewModel)
}