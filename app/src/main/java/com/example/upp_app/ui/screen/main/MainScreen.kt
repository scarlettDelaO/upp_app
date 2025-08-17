package com.example.upp_app.ui.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.upp_app.navigation.NavItem
import com.example.upp_app.ui.components.BottomNavigationBar
import com.example.upp_app.ui.components.FloatingActionButton
import com.example.upp_app.ui.screen.home.HomeScreen
import com.example.upp_app.ui.screen.notification.NotificationScreen
import com.example.upp_app.ui.screen.profile.ProfileScreen
import com.example.upp_app.ui.screen.settings.SettingsScreen


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Notification", Icons.Default.Notifications, 0),
        NavItem("Settings", Icons.Default.Settings, 0),
        NavItem("Profile", Icons.Default.Person, 0),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier.offset(y = 40.dp).size(48.dp)
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomNavigationBar(
                navItemList = navItemList,
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex, navController = navController)
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    navController: NavController
) {
    when (selectedIndex) {
        0 -> HomeScreen()
        1 -> NotificationScreen()
        2 -> SettingsScreen()
        3 -> ProfileScreen(navController = navController)
    }
}