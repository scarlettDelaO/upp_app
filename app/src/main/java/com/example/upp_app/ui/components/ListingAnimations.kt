package com.example.upp_app.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun ListingAnimations(
    index: Int,
    name: String,
    subtitle: String,
    firstVisibleIndex: Int,
    scrollOffset: Int,
    modifier: Modifier = Modifier
) {
    val isFirstVisible = index == firstVisibleIndex && index != 0
    val isFirstItemPartiallyVisible = index == 0 && firstVisibleIndex == 0 && scrollOffset > 0

    // Calculamos un delay relativo al primer ítem visible
    val relativeIndex = (index - firstVisibleIndex).coerceAtLeast(0)
    val dynamicDelay = relativeIndex * 50

    val scale by animateFloatAsState(
        targetValue = if (isFirstVisible || isFirstItemPartiallyVisible) 0.01f else 1f,
        animationSpec = tween(
            durationMillis = 500,
            delayMillis = dynamicDelay,
            easing = LinearOutSlowInEasing
        ),
        label = "scaleAnim"
    )

    val alpha by animateFloatAsState(
        targetValue = if (isFirstVisible || isFirstItemPartiallyVisible) 0.8f else 1f,
        animationSpec = tween(
            durationMillis = 500,
            delayMillis = dynamicDelay,
            easing = LinearOutSlowInEasing
        ),
        label = "alphaAnim"
    )

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.8f),
        exit = fadeOut(animationSpec = tween(500)) + scaleOut(targetScale = 0.8f)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (index % 2 == 0)
                    Color(0xFFB2EBF2)
                else
                    Color(0xFFE1F5FE)
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 6.dp)
                .fillMaxWidth()
                .height(180.dp)
                .scale(scale)
                .alpha(alpha),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}