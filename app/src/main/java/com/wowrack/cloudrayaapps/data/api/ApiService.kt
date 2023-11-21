package com.wowrack.cloudrayaapps.data.api

import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.model.LoginResponse
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("user/auth")
    suspend fun login(
        @Field("appKey") appKey: String,
        @Field("secretKey") secretKey: String
    ): Response<LoginResponse>

    @GET("user/detail")
    suspend fun getUserDetail(
        @Header("Authorization") token: String,
    ): Response<UserDetailResponse>

    @GET("user/detail")
    suspend fun getUserDashboard(
        @Header("Authorization") token: String,
    ): Response<DashboardResponse>

    @GET("user/virtualmachines")
    suspend fun getVMList(
        @Header("Authorization") token: String,
    ): Response<VirtualMachinesResponse>


}