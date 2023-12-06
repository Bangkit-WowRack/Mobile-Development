package com.wowrack.cloudrayaapps.utils

data class Page (
    val title: String,
    val description: String
)

val pages = listOf(
    Page(
        title = "VM Access Anywhere",
        description = "Easily check your VM on-the-go, ensuring constant connectivity."
    ),
    Page(
        title = "Total Control, Anytime",
        description = "Effortlessly manage settings and customization wherever you are."
    ),
    Page(
        title = "Instant Anomaly Alerts",
        description = "Stay informed with real-time notifications for proactive VM management"
    )
)