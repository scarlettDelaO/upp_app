package com.example.upp_app.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.upp_app.R
import com.example.upp_app.ui.components.Listing
import com.example.upp_app.ui.components.ListingAnimations
import com.example.upp_app.ui.theme.PrimaryViolet
import com.example.upp_app.ui.theme.PrimaryVioletLight

@Composable
@Preview
fun HomeScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Listing(
            names = List(12) { "Hello i am card ${it + 1}" },
            modifier = modifier
        ) { index, name, firstVisibleIndex, scrollOffset ->
            ListingAnimations(
                index = index,
                name = name,
                subtitle = "i am subtitle of ${name.takeLastWhile { it.isDigit() }}",
                firstVisibleIndex = firstVisibleIndex,
                scrollOffset = scrollOffset
            )
        }

    }
}





















/*@Composable
fun HomeScreen(modifier : Modifier = Modifier ) {
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
            painter= painterResource(id= R.drawable.ic_home),
            contentDescription=null,
            modifier=Modifier
                .size(300.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Welcome to UPP",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF77DDFB)
        )
        Text(
            text = "This is the Home Screen",
            fontSize = 20.sp,
            color = Color(0xFF77DDFB)
        )

    }
}*/

