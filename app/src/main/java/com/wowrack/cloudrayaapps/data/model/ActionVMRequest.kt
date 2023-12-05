package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ActionVMRequest (

    @SerializedName("vm_id")
    val vmId: Int,

    @SerializedName("request")
    val request: VMAction,

    @SerializedName("release_ip")
    val releaseIp: Boolean,
)

enum class VMAction(val actionName: String) {
    START("start"),
    STOP("stop"),
    REBOOT("reboot")
}
