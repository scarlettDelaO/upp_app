package com.example.upp_app.ui.screen.verify

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.upp_app.R
import com.example.upp_app.ui.components.PrimaryButton
import com.example.upp_app.ui.components.LinkText
import com.example.upp_app.ui.components.Message
import com.example.upp_app.ui.theme.PrimaryVioletLight
import com.example.upp_app.ui.theme.PrimaryViolet

@Composable
fun VerifyCodeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val codeDigits = remember { mutableStateListOf("", "", "", "") }
    val customBlue = Color(0xFFB3E5FC)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                0f to PrimaryViolet,
                1f to PrimaryVioletLight)
            )
            .padding(24.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { navController.popBackStack("register", inclusive = false) }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(R.drawable.ic_email),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top=32.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Message(
            title = "Verify Code",
            subtitle = "Please enter the code we just sent to email"
        )

        Text(
            "example@email.com",
            fontSize = 15.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                OutlinedTextField(
                    value = codeDigits[index],
                    onValueChange = {
                        if (it.length <= 1 && it.all { c -> c.isDigit() }) {
                            codeDigits[index] = it
                        }
                    },
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = customBlue,
                        unfocusedBorderColor = customBlue,
                        cursorColor = customBlue,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 20.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Didn't receive OTP?",
            color = Color.Black
        )
        LinkText(
            text = "Resend code",
            onClick = {
            },
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            onClick = {
                val code = codeDigits.joinToString("")
                navController.navigate("MainScreen") {
                    popUpTo("VerifyCode") { inclusive = true }
                }
            },
            text = "Verify",
            isNavigationArrowVisible = false,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            cornerRadius = 8.dp
        )
    }
}