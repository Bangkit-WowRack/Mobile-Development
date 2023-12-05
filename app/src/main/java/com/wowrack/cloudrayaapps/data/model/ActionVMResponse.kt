package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ActionVMResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Boolean,

	@field:SerializedName("message")
	val message: String
)
