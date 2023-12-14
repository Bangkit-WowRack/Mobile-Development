package com.wowrack.cloudrayaapps

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
import com.wowrack.cloudrayaapps.ui.screen.notification.NotificationScreen
import com.wowrack.cloudrayaapps.ui.screen.otp.OTPScreen
import com.wowrack.cloudrayaapps.ui.screen.profile.ProfileScreen
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceScreen
import com.wowrack.cloudrayaapps.ui.screen.server.ServerScreen
import com.wowrack.cloudrayaapps.ui.screen.setting.SettingScreen
import com.wowrack.cloudrayaapps.ui.screen.welcome.WelcomeScreen
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.utils.showBottomBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    themeSetting: Boolean,
    notificationSetting: Boolean,
    biometricSetting: Boolean,
    changeThemeSetting: (Boolean) -> Unit,
    changeNotificationSetting: (Boolean) -> Unit,
    changeBiometricSetting: (Boolean) -> Unit,
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
                    navigateToStarted = {
                        navController.navigate(Screen.GetStarted.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable(Screen.GetStarted.route) {
                GetStartedScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
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
                        showSnackBar("Login Session Expired")
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToNotification = {
                        navController.navigate(Screen.Notification.route)
                    },
                    navigateToSetting = {
                        navController.navigate(Screen.Setting.route)
                    },
                    navigateToNews = { id ->
                        navController.navigate(Screen.News.createRoute(id))
                    },

                )
            }
            composable(Screen.Notification.route) {
                NotificationScreen(
                    navigateToLogin = {
                        showSnackBar("Login Session Expired")
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                )
            }
            composable(Screen.Setting.route) {
                SettingScreen(
                    themeSetting = themeSetting,
                    notificationSetting = notificationSetting,
                    biometricSetting = biometricSetting,
                    changeThemeSetting = changeThemeSetting,
                    changeNotificationSetting = changeNotificationSetting,
                    changeBiometricSetting = changeBiometricSetting,
                    showSnackBar = showSnackBar
                )
            }
            composable(Screen.Resource.route) {
                ResourceScreen(
                    navigateToLogin = {
                        showSnackBar("Login Session Expired")
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
                        showSnackBar("Login Session Expired")
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
                        showSnackBar("Login Session Expired")
                        navController.navigate(Screen.Login.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToMonitor = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
