package com.game.vivocompose

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes (val route: String) {
    object WelcomeNav : Routes("WelcomeNav")
    object LoginNav : Routes("LoginNav")
    object SignupNav : Routes("SignupNav")
    object HomeNav : Routes("HomeNav")
}