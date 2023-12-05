package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class GetOTPRequest (
    @SerializedName("otp_request_token")
    val otpRequestToken: String,
)