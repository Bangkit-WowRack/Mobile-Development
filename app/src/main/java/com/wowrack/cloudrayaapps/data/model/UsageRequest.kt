package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class UsageRequest(
    @SerializedName("app_key")
    val vmId: Int,
)