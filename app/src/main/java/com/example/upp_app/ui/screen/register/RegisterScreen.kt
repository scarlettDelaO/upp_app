package com.example.upp_app.ui.screen.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.upp_app.ui.components.InputField
import com.example.upp_app.ui.components.Message
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Brush
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.upp_app.ui.components.PrimaryButton
import com.example.upp_app.ui.components.LinkText
import com.example.upp_app.ui.theme.PrimaryVioletLight
import com.example.upp_app.ui.theme.PrimaryViolet
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.upp_app.R

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()

) {
    val checkedColor = Color.Black
    val uncheckedColor = Color.DarkGray

    val agreeChecked = remember { mutableStateOf(false) }
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current
    val registerResult = viewModel.registerResult.value
    val registerError = viewModel.registerError.value

    if (registerResult == true) {
        LaunchedEffect(Unit) {
            navController.navigate("VerifyCode") {
                popUpTo("register") { inclusive = true }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to PrimaryViolet,
                    1f to PrimaryVioletLight
                )
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(R.drawable.ic_register),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top=32.dp)
        )


        Message(
            title = "Create Account",
            subtitle = "Fill your information below or register with your social account."
        )

        Spacer(modifier = Modifier.height(40.dp))

        InputField(
            value = name.value,
            onValueChange = { name.value = it },
            label = "Name",
            placeholder = "Ex. John Doe",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Name"
                )
            }
        )

        Spacer(modifier = Modifier.height(14.dp))

        InputField(
            value = email.value,
            onValueChange = { email.value = it },
            label = "Email",
            placeholder = "example@gmail.com",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
            }
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Campo de Password
        InputField(
            value = password.value,
            onValueChange = { password.value = it },
            label = "Password",
            placeholder = "Enter your password",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password"
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = agreeChecked.value,
                onCheckedChange = { agreeChecked.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = checkedColor,
                    uncheckedColor = uncheckedColor,
                    checkmarkColor = Color.White
                )
            )
            Text(
                text = "Terms & Condition"
            )

        }


        Spacer(modifier = Modifier.height(10.dp))

        PrimaryButton(
            onClick = {
                if (agreeChecked.value) {
                    viewModel.register(
                        name.value,
                        email.value,
                        password.value
                    )
                }
            },
            text = "Sign Up",
            isNavigationArrowVisible = false,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            cornerRadius = 8.dp
        )



        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account?",
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(4.dp))
            LinkText(
                text = "Sign In",
                onClick = {
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                },
            )
        }
        if (!registerError.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = registerError,
                color = Color.Red,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}