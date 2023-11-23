package com.wowrack.cloudrayaapps

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wowrack.cloudrayaapps.ui.components.BottomBar
import com.wowrack.cloudrayaapps.ui.navigation.Screen
import com.wowrack.cloudrayaapps.ui.screen.getstarted.GetStartedScreen
import com.wowrack.cloudrayaapps.ui.screen.home.HomeScreen
import com.wowrack.cloudrayaapps.ui.screen.login.LoginScreen
import com.wowrack.cloudrayaapps.ui.screen.monitor.MonitorScreen
import com.wowrack.cloudrayaapps.ui.screen.profile.ProfileScreen
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceScreen
import com.wowrack.cloudrayaapps.ui.screen.server.ServerScreen
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.utils.showBottomBar

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute.showBottomBar()) {
                BottomBar(
                    navigator = { route: String ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    currentRoute = currentRoute ?: Screen.Home.route
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.GetStarted.route) {
                GetStartedScreen(

                )
            }
            composable(Screen.Login.route) {
                LoginScreen(
                    navigateToHome = {
                        navController.navigate(Screen.Home.route)
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(

                )
            }
            composable(Screen.Resource.route) {
                ResourceScreen(
                    navigateToMonitor = { id ->
                        navController.navigate(Screen.Monitor.createRoute(id))
                    },
                    navigateToServer = { id ->
                        navController.navigate(Screen.Server.createRoute(id))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.Monitor.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("id") ?: ""
                MonitorScreen(id)
            }
            composable(
                route = Screen.Server.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) {
                val id = it.arguments?.getString("id") ?: ""
                ServerScreen(id)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CloudRayaAppsTheme {
        App()
    }
}
