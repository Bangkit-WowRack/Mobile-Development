package com.wowrack.cloudrayaapps.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<ArticleData>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ArticleData(

	@field:SerializedName("creator")
	val creator: Creator,

	@field:SerializedName("creator_type")
	val creatorType: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("quarter_update")
	val quarterUpdate: Any?,

	@field:SerializedName("category_id")
	val categoryId: Int,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("status_msg")
	val statusMsg: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("categories")
	val categories: Categories,

	@field:SerializedName("year_update")
	val yearUpdate: Any?,

	@field:SerializedName("status")
	val status: Int
)

data class Categories(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("creator_id")
	val creatorId: Int,

	@field:SerializedName("id")
	val id: Int
)

data class Creator(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)
