package com.dee.android.hearthstudio.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dee.android.feature_home.HomeDestination

@Composable
fun BottomNavigationBar(
    navController: NavController
) {

    val items = listOf(
        HomeDestination.route to "Home",
        "order" to "Order"
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {

        items.forEach { (route, label) ->

            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                label = { Text(label) },
                icon = {}
            )
        }
    }
}