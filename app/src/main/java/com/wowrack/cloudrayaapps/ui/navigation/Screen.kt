package com.wowrack.cloudrayaapps.ui.navigation

sealed class Screen(val route: String) {
    object GetStarted : Screen("get_started")
    object Login : Screen("login")
    object Home : Screen("home")
    object Resource : Screen("resource")
    object Monitor : Screen("monitor")
    object Server : Screen("server")
    object Profile : Screen("profile")
}