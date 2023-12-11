package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class UsageRequest(
    @SerializedName("vm_id")
    val vmId: Int,
)