package com.wowrack.cloudrayaapps.utils

import com.wowrack.cloudrayaapps.ui.navigation.Screen

fun String.truncateText(maxLength: Int = 80): String {
    return if (this.length <= maxLength) {
        this
    } else {
        this.substring(0, maxLength - 3) + "..."
    }
}

fun String?.showBottomBar(): Boolean {
    return when (this) {
        Screen.Home.route -> true
        Screen.Resource.route -> true
        Screen.Profile.route -> true
        else -> false
    }
}