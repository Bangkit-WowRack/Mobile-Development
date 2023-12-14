package com.wowrack.cloudrayaapps.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object GetStarted : Screen("get_started")
    object Login : Screen("login")
    object OTPScreen : Screen("otp_screen/{otpToken}/{key}") {
        fun createRoute(otpToken: String, key: String) = "otp_screen/$otpToken/$key"
    }
    object Home : Screen("home")
    object Resource : Screen("resource")
    object Profile : Screen("profile")
    object Monitor : Screen("monitor/{id}") {
        fun createRoute(id: Int) = "monitor/$id"
    }
    object Server : Screen("server/{id}") {
        fun createRoute(id: Int) = "server/$id"
    }
    object Notification : Screen("notification")

    object Setting : Screen("Setting")

    object News : Screen("News") {
        fun createRoute(id: Int) = "news/$id"
    }
}