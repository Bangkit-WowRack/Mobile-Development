package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("error")
	val error: String,

	@field:SerializedName("message")
	val message: String
)
