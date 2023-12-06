package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ConsoleResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: String,

	@field:SerializedName("message")
	val message: String
)
