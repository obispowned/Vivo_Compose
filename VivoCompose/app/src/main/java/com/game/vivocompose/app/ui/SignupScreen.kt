package com.game.vivocompose.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import com.game.vivocompose.app.model.SignupViewModel
import com.game.vivocompose.ui.theme.gotham
import kotlin.math.sign

@Composable
fun SignupScreen(navController: NavController, signupViewModel: SignupViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color_background))
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MyLogo()
        SubTitle(stringResource(R.string.descubre_un))
        Spacer(modifier = Modifier.weight(1f))
        SignupEmailPassword(
            modifier = Modifier
                .fillMaxWidth(), signupViewModel
        )
        Spacer(modifier = Modifier.weight(1f))
        SignupRegistrarse(navController = navController, signupViewModel = signupViewModel)
        Spacer(modifier = Modifier.padding(5.dp))
        SignupYaTienesCuenta(navController = navController, signupViewModel = signupViewModel)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SignupEmailPassword(modifier: Modifier, signupViewModel: SignupViewModel) {
    val email: String by signupViewModel.email.observeAsState(initial = "")
    val password: String by signupViewModel.password.observeAsState(initial = "")
    val confirmPassword: String by signupViewModel.confirmPassword.observeAsState(initial = "")
    val isLoading: Boolean by signupViewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        SignupEmail(email) { signupViewModel.onEmailChanged(it) }
        SignupPassword(password) { signupViewModel.onPassChanged(it) }
        SignupConfirmPassword(confirmPassword) { signupViewModel.onConfirmPassChanged(it) }
        Spacer(modifier = Modifier.padding(5.dp))
        TuPassDebeTener()
    }
}

@Composable
fun TuPassDebeTener() {
    Text(text = stringResource(R.string.SecurePassword), fontSize = 12.sp)
}

@Composable
fun SignupEmail(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
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
fun SignupPassword(password: String, onTextFieldChange: (String) -> Unit) {
    var hidden by remember { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = { onTextFieldChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
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
fun SignupConfirmPassword(confirmPassword: String, onTextFieldChange: (String) -> Unit) {
    var hidden by remember { mutableStateOf(true) }

    TextField(
        value = confirmPassword,
        onValueChange = { onTextFieldChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Confirm Password") },
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
private fun SignupRegistrarse(navController: NavController, signupViewModel: SignupViewModel) {
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
            navController.navigate(Routes.LoginNav.route) }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.Registrate),
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}

@Composable
private fun SignupYaTienesCuenta(navController: NavController, signupViewModel: SignupViewModel) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.color_primary2)
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_background)),
        shape = RoundedCornerShape(50),
        onClick = { navController.navigate(Routes.LoginNav.route) }) {
        Text(
            modifier = Modifier.padding(13.dp),
            text = stringResource(R.string.tienesya),
            color = colorResource(id = R.color.color_primary2),
            fontWeight = FontWeight.Bold,
            fontFamily = gotham,
            fontSize = 12.sp,
            letterSpacing = 0.2.em
        )
    }
}