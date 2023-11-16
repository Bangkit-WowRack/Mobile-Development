package com.wowrack.cloudrayaapps.ui.navigation

sealed class Screen(val route: String) {
    object GetStarted : Screen("get_started")
    object Login : Screen("login")
    object Home : Screen("home")
    object Resource : Screen("resource")
    object Profile : Screen("profile")
    object Monitor : Screen("monitor/{id}") {
        fun createRoute(id: String) = "monitor/$id"
    }
    object Server : Screen("server/{id}") {
        fun createRoute(id: String) = "server/$id"
    }
}