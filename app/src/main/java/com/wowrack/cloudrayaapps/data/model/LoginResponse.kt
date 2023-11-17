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

	@field:SerializedName("refresh_token")
	val refreshToken: String,

	@field:SerializedName("bearer_token")
	val bearerToken: String,

	@field:SerializedName("timezone")
	val timezone: String,

	@field:SerializedName("expired_at")
	val expiredAt: String,

	@field:SerializedName("username")
	val username: String
)
