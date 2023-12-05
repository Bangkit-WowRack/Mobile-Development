package com.wowrack.cloudrayaapps.data.api

import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.model.GetOTPRequest
import com.wowrack.cloudrayaapps.data.model.GetOTPResponse
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.model.LoginResponse
import com.wowrack.cloudrayaapps.data.model.OTPRequest
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.data.model.VMDetailResponse
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("user/auth")
    suspend fun login(
        @Body requestBody: LoginRequest
    ): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("user/auth/verify-otp")
    suspend fun verifyOTP(
        @Body requestBody: OTPRequest
    ): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("user/auth/get-otp")
    suspend fun getOTP(
        @Body requestBody: GetOTPRequest
    ): Response<GetOTPResponse>

    @GET("user/detail")
    suspend fun getUserDetail(
        @Header("Authorization") token: String,
    ): Response<UserDetailResponse>

    @GET("user/dashboard/list")
    suspend fun getUserDashboard(
        @Header("Authorization") token: String,
    ): Response<DashboardResponse>

    @GET("user/virtualmachines")
    suspend fun getVMList(
        @Header("Authorization") token: String,
    ): Response<VirtualMachinesResponse>

    @GET("user/virtualmachines/{id}")
    suspend fun getVMDetail(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<VMDetailResponse>
}