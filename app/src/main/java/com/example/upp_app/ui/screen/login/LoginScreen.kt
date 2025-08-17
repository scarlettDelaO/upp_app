package com.example.upp_app.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.upp_app.R
import com.example.upp_app.ui.components.InputField
import com.example.upp_app.ui.theme.PrimaryVioletLight
import com.example.upp_app.ui.theme.PrimaryViolet
import com.example.upp_app.ui.components.Message
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.example.upp_app.ui.components.PrimaryButton
import com.example.upp_app.ui.components.Checkbox
import com.example.upp_app.ui.components.LinkText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.compose.runtime.LaunchedEffect
import androidx.fragment.app.FragmentActivity
import com.example.upp_app.ui.screen.login.LoginViewModel
import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import com.example.upp_app.biometric.authenticateUser
import androidx.compose.material3.Button


@Composable
    fun LoginScreen(
        modifier: Modifier = Modifier,
        navController: NavController,
        viewModel: LoginViewModel = viewModel()
    ){
        val rememberMeChecked = remember { mutableStateOf(false) }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val context = LocalContext.current
        val activity = context as? FragmentActivity
        val loginResult = viewModel.loginResult.value
        val errorMessage = viewModel.errorMessage.value

        //NAVEGACION
        if (loginResult != null) {
            LaunchedEffect(Unit) {
                navController.navigate("MainScreen") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }

        Column (
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
        ){
            Image(
                painter = painterResource(R.drawable.ic_login),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top=32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Message(
                title = "Sign In",
                subtitle = "Hi! Welcome back,your've been missied"
            )

            Spacer(modifier = Modifier.height(24.dp))

            InputField(
                value = email.value,
                onValueChange = { email.value = it },
                label = "Email",
                placeholder = "Enter your email",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email"
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputField(
                value = password.value,
                onValueChange = { password.value = it },
                label = "Password",
                placeholder = "Enter your password",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.RemoveRedEye,
                        contentDescription = "Password"
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMeChecked.value,
                    onCheckedChange = { rememberMeChecked.value = it },
                    text = "Remember me",
                )

                LinkText(
                    text = "Forgot password?",
                    onClick = {
                        navController.navigate("VerifyCode") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                onClick = {
                    viewModel.login(
                        email.value,
                        password.value)
                },
                text = "Login",
                isNavigationArrowVisible = true,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.DarkGray
                ),
                cornerRadius = 8.dp
            )

            Spacer(modifier = Modifier.height(15.dp))
            //Huella Dactilar
            Image(
                painter = painterResource(id = R.drawable.ic_biometric),
                contentDescription = "Biometric Icon",
                modifier = Modifier
                    .size(72.dp)
                    .clickable {
                        activity?.let {
                            authenticateUser(
                                context = context,
                                activity = it,
                                onSuccess = {
                                    Toast.makeText(context, "Correct fingerprint", Toast.LENGTH_SHORT).show()
                                    navController.navigate("MainScreen") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                    .padding(top = 16.dp)
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
                    text = "Don't have an account? ",
                    color = Color.Black
                )
                LinkText(
                    text = "Register",
                    onClick = {
                        navController.navigate("register") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                )
            }
        }
        if (!errorMessage.isNullOrBlank()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

