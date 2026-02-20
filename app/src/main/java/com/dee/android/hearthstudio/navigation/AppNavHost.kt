package com.dee.android.hearthstudio.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dee.android.feature_home.homeScreen
import com.dee.android.feature_home.HomeDestination
import com.dee.android.feature_order.orderScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = HomeDestination.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeScreen()
            orderScreen()
        }
    }
}

private val bottomItems = listOf(
    BottomDestination(
        route = HomeDestination.route,
        label = "Home"
    ),
    BottomDestination(
        route = "order", // 如果你有 OrderDestination 就用它
        label = "Order"
    )
)