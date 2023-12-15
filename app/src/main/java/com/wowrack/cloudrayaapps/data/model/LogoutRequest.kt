package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    @SerializedName("device_token")
    val deviceToken: String,
)