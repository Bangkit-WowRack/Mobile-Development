package com.wowrack.cloudrayaapps

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.wowrack.cloudrayaapps.ui.screen.otp.OTPScreen
import com.wowrack.cloudrayaapps.ui.screen.profile.ProfileScreen
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceScreen
import com.wowrack.cloudrayaapps.ui.screen.server.ServerScreen
import com.wowrack.cloudrayaapps.ui.screen.welcome.WelcomeScreen
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.utils.showBottomBar
import kotlinx.coroutines.launch

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val showSnackBar = { message: String ->
        scope.launch {
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            if (currentRoute.showBottomBar()) {
                BottomBar(
                    navigator = { route: String ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.id) {
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
            startDestination = Screen.Welcome.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Welcome.route) {
                WelcomeScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                )
            }
            composable(Screen.GetStarted.route) {
                GetStartedScreen(

                )
            }
            composable(Screen.Login.route) {
                LoginScreen(
                    navigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                            navController.popBackStack()
                        }
                    },
                    navigateToOTP = { otpToken, key ->
                        navController.navigate(Screen.OTPScreen.createRoute(otpToken, key)) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable(Screen.OTPScreen.route) {
                val otpToken = it.arguments?.getString("otpToken") ?: ""
                val key = it.arguments?.getString("key") ?: ""
                OTPScreen(
                    otpToken = otpToken,
                    key = key,
                    navigateToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                            navController.popBackStack()
                        }
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                )
            }
            composable(Screen.Resource.route) {
                ResourceScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToMonitor = { id ->
                        navController.navigate(Screen.Monitor.createRoute(id))
                    },
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                )
            }
            composable(
                route = Screen.Monitor.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("id") ?: 0
                MonitorScreen(
                    id = id,
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToServer = { vmId ->
                        navController.navigate(Screen.Server.createRoute(vmId))
                    },
                    snackbar = showSnackBar
                )
            }
            composable(
                route = Screen.Server.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("id") ?: 0
                ServerScreen(
                    id = id,
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                )
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
