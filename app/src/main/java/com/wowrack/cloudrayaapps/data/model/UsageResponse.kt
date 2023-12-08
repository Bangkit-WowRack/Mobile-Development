package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class UsageResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DataCpu>,

	@field:SerializedName("message")
	val message: String
)

data class DataCpu(

	@field:SerializedName("cpuUsed")
	val cpuUsed: Float,

	@field:SerializedName("memoryUsed")
	val memoryUsed: Float,

	@field:SerializedName("timestamp")
	val timestamp: String
)
