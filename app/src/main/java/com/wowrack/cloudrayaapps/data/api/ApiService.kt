package com.wowrack.cloudrayaapps.data.api

import com.wowrack.cloudrayaapps.data.model.ActionVMRequest
import com.wowrack.cloudrayaapps.data.model.ActionVMResponse
import com.wowrack.cloudrayaapps.data.model.BandwidthRequest
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.ConsoleRequest
import com.wowrack.cloudrayaapps.data.model.ConsoleResponse
import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.model.GetOTPRequest
import com.wowrack.cloudrayaapps.data.model.GetOTPResponse
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.model.LoginResponse
import com.wowrack.cloudrayaapps.data.model.OTPRequest
import com.wowrack.cloudrayaapps.data.model.UsageRequest
import com.wowrack.cloudrayaapps.data.model.UsageResponse
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
import retrofit2.http.Query

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth")
    suspend fun login(
        @Body requestBody: LoginRequest
    ): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("auth/verify-otp")
    suspend fun verifyOTP(
        @Body requestBody: OTPRequest
    ): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("auth/get-otp")
    suspend fun getOTP(
        @Body requestBody: GetOTPRequest
    ): Response<GetOTPResponse>

    @GET("detail")
    suspend fun getUserDetail(
        @Header("Authorization") token: String,
    ): Response<UserDetailResponse>

    @GET("dashboard/list")
    suspend fun getUserDashboard(
        @Header("Authorization") token: String,
    ): Response<DashboardResponse>

    @GET("virtualmachines")
    suspend fun getVMList(
        @Header("Authorization") token: String,
    ): Response<VirtualMachinesResponse>

    @GET("virtualmachines/{id}")
    suspend fun getVMDetail(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<VMDetailResponse>

    @Headers("Content-Type: application/json")
    @POST("virtualmachines/usages")
    suspend fun getVMUsage(
        @Header("Authorization") token: String,
        @Body requestBody: UsageRequest,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<UsageResponse>

    @Headers("Content-Type: application/json")
    @POST("virtualmachines/bandwidths")
    suspend fun getVMBandwidth(
        @Header("Authorization") token: String,
        @Body requestBody: BandwidthRequest,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<BandwidthResponse>

    @Headers("Content-Type: application/json")
    @POST("virtualmachines/action")
    suspend fun actionVM(
        @Header("Authorization") token: String,
        @Body requestBody: ActionVMRequest
    ): Response<ActionVMResponse>

    @Headers("Content-Type: application/json")
    @POST("virtualmachines/open-console")
    suspend fun openConsole(
        @Header("Authorization") token: String,
        @Body requestBody: ConsoleRequest
    ): Response<ConsoleResponse>
}