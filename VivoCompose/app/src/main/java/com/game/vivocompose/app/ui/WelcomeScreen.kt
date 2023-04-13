package com.game.vivocompose.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.game.vivocompose.R
import com.game.vivocompose.Routes
import com.game.vivocompose.app.model.WelcomeViewModel
import com.game.vivocompose.ui.theme.gotham

@Composable
fun WelcomeScreen(navController: NavController, welcomeViewModel: WelcomeViewModel) {
    MaterialTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.background)
                .padding(horizontal = 30.dp), //vertical = 100.dp,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            MyLogo()
            Spacer(modifier = Modifier.size(15.dp))
            SubTitle(stringResource(R.string.vivir_mejor))
            Spacer(modifier = Modifier.weight(1f))
            IniciaSesionWelcome(navController, welcomeViewModel)
            Spacer(modifier = Modifier.size(15.dp))
            WelcomeDivider()
            Spacer(modifier = Modifier.size(15.dp))
            RegistrateWelcome(navController, welcomeViewModel)
            Spacer(modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun MyLogo() {
    Image(
        modifier = Modifier.padding(horizontal = 60.dp), //Modifier.size(200.dp)
        painter = painterResource(id = R.drawable.logo10),
        contentDescription = "logo_vivo"
    )
}

@Composable
fun SubTitle(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSurface,
        fontSize = 18.sp,
        letterSpacing = 0.2.em
    )
}

@Composable
fun WelcomeDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .padding(start = 40.dp)
                .background(Color.Black)
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "Ó",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            color = MaterialTheme.colors.onSurface
        )
        Divider(
            Modifier
                .padding(end = 40.dp)
                .background(Color.Black)
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
private fun IniciaSesionWelcome(navController: NavController, welcomeViewModel: WelcomeViewModel) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.color_primary2)
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_background)),
        shape = RoundedCornerShape(50),
        onClick = { navController.navigate(Routes.LoginNav.route) }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.IniciaSesion),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            color = MaterialTheme.colors.onSurface,
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}

@Composable
private fun RegistrateWelcome(navController: NavController, welcomeViewModel: WelcomeViewModel) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.color_primary2)
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_primary2)),
        shape = RoundedCornerShape(50),
        onClick = { navController.navigate(Routes.SignupNav.route) }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.Registrate),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            color = colorResource(id = R.color.white),
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}
