package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class UsageResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<UsageData>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class UsageData(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("cpu_used")
	val cpuUsed: String? = null,

	@field:SerializedName("diskio_write")
	val diskioWrite: String? = null,

	@field:SerializedName("hour")
	val hour: Int? = null,

	@field:SerializedName("converted_hour")
	val convertedHour: Int? = null,

	@field:SerializedName("memory_used")
	val memoryUsed: String? = null,

	@field:SerializedName("diskio_read")
	val diskioRead: String? = null,

	@field:SerializedName("converted_day")
	val convertedDay: Int? = null
)
