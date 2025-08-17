package com.example.upp_app.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.upp_app.R
import com.example.upp_app.ui.components.PrimaryButton
import com.example.upp_app.ui.theme.PrimaryViolet
import com.example.upp_app.ui.theme.PrimaryVioletLight

@Composable
fun ProfileScreen(
    modifier : Modifier = Modifier,
    navController: NavController
) {
    Column (
        modifier = modifier.fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to PrimaryViolet,
                    1f to PrimaryVioletLight
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter= painterResource(id= R.drawable.ic_profile),
            contentDescription=null,
            modifier=Modifier
                .size(300.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hello",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF77DDFB)
        )
        Text(
            text = "This is the Profile Screen",
            fontSize = 20.sp,
            color = Color(0xFF77DDFB)
        )

        Spacer(modifier = Modifier.height(15.dp))

        PrimaryButton(
            onClick = {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            },
            text = "Log Out",
            isNavigationArrowVisible = false,
            modifier = Modifier
                .width(180.dp)
                .padding(horizontal = 5.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            cornerRadius = 8.dp
        )

    }
}