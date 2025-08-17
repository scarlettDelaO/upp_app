package com.example.upp_app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.upp_app.navigation.NavItem

@Composable
fun BottomNavigationBar(
    navItemList: List<NavItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        navItemList.forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { onItemSelected(index) },
                icon = {
                    if (navItem.badgeCount > 0) {
                        BadgedBox(badge = { Badge { Text(text = navItem.badgeCount.toString()) } }) {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = "Icon",
                                tint = if (selectedIndex == index) Color(0xFF77DDFB) else Color.DarkGray
                            )
                        }
                    } else {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = "Icon",
                            tint = if (selectedIndex == index) Color(0xFF77DDFB) else Color.DarkGray
                        )
                    }
                },
                label = {
                    Text(
                        text = navItem.label,
                            color = Color.Black
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

