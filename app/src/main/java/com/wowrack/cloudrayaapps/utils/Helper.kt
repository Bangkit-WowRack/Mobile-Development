package com.wowrack.cloudrayaapps.utils

import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.ui.common.UiState
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

fun Int.getStatus(): String {
    return when (this) {
        1 -> "Active"
        2 -> "Pending"
        3 -> "Suspended"
        4 -> "Terminated"
        else -> "Unknown"
    }
}

fun Int.getIcon(): String {
    return when (this) {
        1 -> "🟢"
        2 -> "🟡"
        3 -> "🟠"
        4 -> "🔴"
        else -> "❓"
    }
}

fun UsageResponse.getCPUUsage(): List<Pair<Int, Double>> {
    val data = mutableListOf<Pair<Int, Double>>()
    this.data.forEachIndexed { index, dataCpu ->
        data.add(Pair(index + 1, dataCpu.cpuUsed.toDouble()))
    }
    return data
}

fun UsageResponse.getMemoryUsage(): List<Pair<Int, Double>> {
    val data = mutableListOf<Pair<Int, Double>>()
    this.data.forEachIndexed { index, dataCpu ->
        data.add(Pair(index + 1, dataCpu.memoryUsed.toDouble()))
    }
    return data
}

