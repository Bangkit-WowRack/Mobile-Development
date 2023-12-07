package com.wowrack.cloudrayaapps.ui.common

import com.wowrack.cloudrayaapps.R

data class Page (
    val title: String,
    val description: String,
    val image: Int
)

val pages = listOf(
    Page(
        title = "VM Access Anywhere",
        description = "Easily check your VM on-the-go, ensuring constant connectivity.",
        image = R.drawable.first_started
    ),
    Page(
        title = "Total Control, Anytime",
        description = "Effortlessly manage settings and customization wherever you are.",
        image = R.drawable.second_started
    ),
    Page(
        title = "Instant Anomaly Alerts",
        description = "Stay informed with real-time notifications for proactive VM management",
        image = R.drawable.third_started
    )
)