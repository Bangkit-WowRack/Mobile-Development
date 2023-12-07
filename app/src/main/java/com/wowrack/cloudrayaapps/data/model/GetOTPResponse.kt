package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class GetOTPResponse (

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("data")
    val data: OTPData,

    @field:SerializedName("message")
    val message: String,
)

data class OTPData (
    @field:SerializedName("verify_otp_token")
    val verifyOtpToken: String,

    @field:SerializedName("user_email")
    val email: String
)