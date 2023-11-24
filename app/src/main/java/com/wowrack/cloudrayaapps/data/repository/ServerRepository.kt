package com.wowrack.cloudrayaapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.dummy.getDummyBandwidthResponse
import com.wowrack.cloudrayaapps.data.dummy.getDummyUsageResponse
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.ErrorResponse
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.data.model.VMDetailResponse
import com.wowrack.cloudrayaapps.data.utils.getTokenAndValidate
import kotlinx.coroutines.Dispatchers

class ServerRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
    private val validateLogin: suspend () -> Boolean
) {

    fun getVMList(): LiveData<Result<VirtualMachinesResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token != null) {
                val response = apiService.getVMList(token)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        emit(Result.Success(body))
                    } else {
                        emit(Result.Error("Something went wrong"))
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    if (!errorBody.isNullOrBlank()) {
                        val gson = Gson()
                        val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
                        emit(Result.Error(errorResponse.message))
                    } else {
                        emit(Result.Error("Something went wrong"))
                    }
                }

            } else {
                emit(Result.NotLogged)
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getVMDetail(id: Int): LiveData<Result<VMDetailResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token == null) {
                emit(Result.NotLogged)
                return@liveData
            }

            val response = apiService.getVMDetail(token, id)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Result.Success(body))
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                if (!errorBody.isNullOrBlank()) {
                    val gson = Gson()
                    val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
                    emit(Result.Error(errorResponse.message))
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getVMUsage(id: Int): LiveData<Result<UsageResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            emit(Result.Success(getDummyUsageResponse()))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getVMBandwidth(id: Int): LiveData<Result<BandwidthResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            emit(Result.Success(getDummyBandwidthResponse()))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: ServerRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService,
            validateLogin: suspend () -> Boolean
        ): ServerRepository =
            instance ?: synchronized(this) {
                instance ?: ServerRepository(
                    userPreference,
                    apiService,
                    validateLogin
                )
            }.also { instance = it }
    }
}