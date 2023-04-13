package com.game.vivocompose.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.game.vivocompose.R
import com.game.vivocompose.Routes
import com.game.vivocompose.app.model.LoginViewModel
import com.game.vivocompose.ui.theme.gotham


@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        MyLogo()
        SubTitle(stringResource(R.string.vivir_mejor))
        Spacer(modifier = Modifier.weight(0.75f))
        LoginEmailPassword(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), loginViewModel
        )
        Spacer(modifier = Modifier.weight(1.25f))
        LoginIniciaSesion(navController = navController, loginViewModel = loginViewModel)
        Spacer(modifier = Modifier.padding(5.dp))
        LoginRegistrate(navController = navController, loginViewModel = loginViewModel)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun LoginEmailPassword(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        LoginEmail(email) { loginViewModel.onEmailChanged(it) }
        LoginPassword(password) { loginViewModel.onPassChanged(it) }
        Spacer(modifier = Modifier.padding(5.dp))
        Forgotpass()

    }
}

@Composable
fun Forgotpass() {
    Text(
        modifier = Modifier.clickable { },
        text = stringResource(id = R.string.OlvidadoTuContraseña),
        fontSize = 12.sp
    )
}

@Composable
fun LoginEmail(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Email") },
        //placeholder = { Text(text = "Correo electronico") }, //al pulsar
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), //nos provee arroba en el teclado
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.color_black),
            cursorColor = MaterialTheme.colors.onSurface,
            leadingIconColor = MaterialTheme.colors.primaryVariant,
            focusedLabelColor = MaterialTheme.colors.onSurface,
            backgroundColor = colorResource(id = R.color.color_background),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Gray,
        )
    )
}

@Composable
fun LoginPassword(password: String, onTextFieldChange: (String) -> Unit) {

    var hidden by remember { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = { onTextFieldChange(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Password") },
        //placeholder = { Text(text = "Contraseña") }, //al pulsar
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "")
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.color_black),
            cursorColor = MaterialTheme.colors.onSurface,
            leadingIconColor = MaterialTheme.colors.primaryVariant,
            focusedLabelColor = MaterialTheme.colors.onSurface,
            backgroundColor = colorResource(id = R.color.color_background),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Gray,
        ),
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
        trailingIcon = {// 4
            IconButton(onClick = { hidden = !hidden }) {
                val vector = painterResource(//5
                    if (hidden) R.drawable.visibility_on
                    else R.drawable.visibility_off
                )
                val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña" //6
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
}

@Composable
private fun LoginIniciaSesion(navController: NavController, loginViewModel: LoginViewModel) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.color_primary2)
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_primary2)),
        shape = RoundedCornerShape(50),
        onClick = { /*VERIFICAR LOGIN*/
            navController.navigate(Routes.HomeNav.route)
        }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.IniciaSesion),
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}

@Composable
private fun LoginRegistrate(navController: NavController, loginViewModel: LoginViewModel) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.color_primary2)
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_background)),
        shape = RoundedCornerShape(50),
        onClick = { navController.navigate(Routes.SignupNav.route) }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.NoTienesCuenta),
            color = colorResource(id = R.color.color_primary2),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}

