package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class NotificationResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<NotificationItem>,

	@field:SerializedName("message")
	val message: String
)

data class NotificationItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("vm_id")
	val vmId: Int,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("timestamp")
	val timestamp: Long
)
