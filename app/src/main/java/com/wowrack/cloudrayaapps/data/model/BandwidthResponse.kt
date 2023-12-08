package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class BandwidthResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<BandwidthData>,

	@field:SerializedName("message")
	val message: String
)

data class BandwidthData(

	@field:SerializedName("cost")
	val cost: Int,

	@field:SerializedName("usage")
	val usage: Float,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("timestamp")
	val timestamp: String
)
