package com.wowrack.cloudrayaapps

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MiscellaneousServices
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.StackedLineChart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wowrack.cloudrayaapps.ui.navigation.NavigationItem
import com.wowrack.cloudrayaapps.ui.navigation.Screen
import com.wowrack.cloudrayaapps.ui.screen.getstarted.GetStartedScreen
import com.wowrack.cloudrayaapps.ui.screen.home.HomeScreen
import com.wowrack.cloudrayaapps.ui.screen.login.LoginScreen
import com.wowrack.cloudrayaapps.ui.screen.monitor.MonitorScreen
import com.wowrack.cloudrayaapps.ui.screen.profile.ProfileScreen
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceScreen
import com.wowrack.cloudrayaapps.ui.screen.server.ServerScreen
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Login.route && currentRoute != Screen.GetStarted.route) {
                BottomBar(navController)
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

                )
            }
            composable(Screen.Monitor.route) {
                MonitorScreen(

                )
            }
            composable(Screen.Server.route) {
                ServerScreen(

                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(

                )
            }

        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.menu_home),
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = stringResource(R.string.menu_resource),
            icon = Icons.Default.MiscellaneousServices,
            screen = Screen.Resource
        ),
        NavigationItem(
            title = stringResource(R.string.menu_monitor),

            icon = Icons.Default.Monitor,
            screen = Screen.Monitor
        ),
        NavigationItem(
            title = stringResource(R.string.menu_server),
            icon = Icons.Default.Security,
            screen = Screen.Server
        ),
        NavigationItem(
            title = stringResource(R.string.menu_profile),
            icon = Icons.Default.AccountCircle,
            screen = Screen.Profile
        ),
    )

    NavigationBar(
        modifier = modifier,
    ) {
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
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
