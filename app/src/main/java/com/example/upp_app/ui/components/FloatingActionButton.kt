package com.example.upp_app.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Color(0xFF77DDFB),
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(4.dp),
        shape = CircleShape,
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}