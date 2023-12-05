package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class OTPRequest (
    @SerializedName("otp")
    val otp: String,

    @SerializedName("otp_verify_token")
    val verifyOtpToken: String,
)