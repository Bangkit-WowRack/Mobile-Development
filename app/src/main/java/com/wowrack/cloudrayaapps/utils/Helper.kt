package com.wowrack.cloudrayaapps.utils

import com.wowrack.cloudrayaapps.data.model.BandwidthData
import com.wowrack.cloudrayaapps.data.model.DataCpu
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.navigation.Screen
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

fun List<DataCpu>.getCPUUsage(): List<Pair<Int, Double>> {
    val data = mutableListOf<Pair<Int, Double>>()
    this.forEachIndexed { index, dataCpu ->
        data.add(Pair(index + 1, dataCpu.cpuUsed.toDouble()))
    }
    return data
}

fun List<DataCpu>.getMemoryUsage(): List<Pair<Int, Double>> {
    val data = mutableListOf<Pair<Int, Double>>()
    this.forEachIndexed { index, dataCpu ->
        data.add(Pair(index + 1, dataCpu.memoryUsed.toDouble()))
    }
    return data
}

fun List<BandwidthData>.getBandwidthUsage(): List<Pair<Int, Double>> {
    val data = mutableListOf<Pair<Int, Double>>()
    this.forEachIndexed { index, bandwidthData ->
        data.add(Pair(index + 1, bandwidthData.usage.toDouble()))
    }
    return data
}

fun String.timestampToHourMinute(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    val dateTime = LocalDateTime.parse(this, formatter)

    val hourMinuteFormatter = DateTimeFormatter.ofPattern("HH:mm")
    return dateTime.format(hourMinuteFormatter)
}

