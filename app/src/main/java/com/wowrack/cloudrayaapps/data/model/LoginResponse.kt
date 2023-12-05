package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: User,

	@field:SerializedName("message")
	val message: String
)

data class User(

	@field:SerializedName("need_otp")
	val needOtp: Boolean,

	@field:SerializedName("otp_request_token")
	val otpRequestToken: String? = null,

	@field:SerializedName("refresh_token")
	val refreshToken: String? = null,

	@field:SerializedName("bearer_token")
	val bearerToken: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("expired_at")
	val expiredAt: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
