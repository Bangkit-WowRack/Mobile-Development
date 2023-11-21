package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class BandwidthResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<BandwidthData>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class BandwidthData(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("hour")
	val hour: Int? = null,

	@field:SerializedName("usage")
	val usage: Int? = null,

	@field:SerializedName("converted_date")
	val convertedDate: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
