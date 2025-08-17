package com.example.upp_app.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.graphics.Color

@Composable
fun LinkText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color ( 0xFFB3E5FC)
) {
    ClickableText(
        text = AnnotatedString(text),
        onClick = { onClick() },
        style = MaterialTheme.typography.bodyMedium.copy(color = color),
        modifier = modifier
    )
}
