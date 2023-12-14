package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class SubscribeNotificationRequest (
    @SerializedName("fcm_token")
    val fcmToken: String,

    @SerializedName("device_token")
    val deviceToken: String,
)