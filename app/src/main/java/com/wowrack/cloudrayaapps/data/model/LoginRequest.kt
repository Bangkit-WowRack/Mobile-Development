package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("app_key")
    val appKey: String,

    @SerializedName("secret_key")
    val secretKey: String,

    @SerializedName("device_token")
    val deviceToken: String,
)