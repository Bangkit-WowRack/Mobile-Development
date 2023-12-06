package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ConsoleRequest (
    @SerializedName("vm_id")
    val vmId: String
)