package com.wowrack.cloudrayaapps.data.api

import com.wowrack.cloudrayaapps.data.model.LoginResponse
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("appKey") appKey: String,
        @Field("secretKey") secretKey: String
    ): Response<LoginResponse>

    @GET("login")
    suspend fun getUserDetail(
        @Header("Authorization") token: String,
    ): Response<UserDetailResponse>
}