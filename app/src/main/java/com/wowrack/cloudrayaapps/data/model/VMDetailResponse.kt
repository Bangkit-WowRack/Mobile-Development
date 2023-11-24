package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class VMDetailResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: VMDetailData,

	@field:SerializedName("message")
	val message: String
)

data class Sshkeypair(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("cs_name")
	val csName: String
)

data class VMDetailData(

	@field:SerializedName("maydestroy")
	val maydestroy: Int,

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("suspend_date")
	val suspendDate: String,

	@field:SerializedName("public_ip")
	val publicIp: String,

	@field:SerializedName("memory")
	val memory: Int,

	@field:SerializedName("vpc_id")
	val vpcId: Int,

	@field:SerializedName("timezone")
	val timezone: String,

	@field:SerializedName("package_id")
	val packageId: Int,

	@field:SerializedName("private_ip")
	val privateIp: List<String>,

	@field:SerializedName("location_id")
	val locationId: Int,

	@field:SerializedName("security_profile")
	val securityProfile: String? = null,

	@field:SerializedName("hostname")
	val hostname: String,

	@field:SerializedName("sshkeypair")
	val sshkeypair: Sshkeypair,

	@field:SerializedName("currency")
	val currency: String,

	@field:SerializedName("state")
	val state: String,

	@field:SerializedName("rootdisk_size")
	val rootdiskSize: Int,

	@field:SerializedName("security_id")
	val securityId: Int,

	@field:SerializedName("disk_id")
	val diskId: String,

	@field:SerializedName("package")
	val jsonMemberPackage: String,

	@field:SerializedName("os")
	val os: String,

	@field:SerializedName("vpc")
	val vpc: String,

	@field:SerializedName("cpu")
	val cpu: String,

	@field:SerializedName("ostype")
	val ostype: String,

	@field:SerializedName("vpc_network")
	val vpcNetwork: String,

	@field:SerializedName("move_subnet_progress")
	val moveSubnetProgress: Int,

	@field:SerializedName("disk")
	val disk: String,

	@field:SerializedName("project_tag")
	val projectTag: String? = null,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("launch_date")
	val launchDate: String,

	@field:SerializedName("created_date")
	val createdDate: String,

	@field:SerializedName("image_id")
	val imageId: String,

	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("status")
	val status: String
)
