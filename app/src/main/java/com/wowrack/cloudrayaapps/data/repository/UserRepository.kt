package com.wowrack.cloudrayaapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.model.User
import com.wowrack.cloudrayaapps.data.pref.StartedPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.ErrorResponse
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.data.utils.apiCallWithAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
    private val startedPreference: StartedPreference
) {

    fun login(appKey: String, secretKey: String): LiveData<Result<Boolean>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)

            try {
                val response = apiService.login(appKey, secretKey)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val data = body.data
                        saveSession(data)
                        emit(Result.Success(true))
                    } else {
                        emit(Result.Error("Login Failed"))
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    if (!errorBody.isNullOrBlank()) {
                        val gson = Gson()
                        val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
                        emit(Result.Error(errorResponse.message))
                    } else {
                        emit(Result.Error("Login Failed"))
                    }
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }

    fun getUserDetail(): LiveData<Result<UserDetailResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            apiCallWithAuth(userPreference) {
                val response = apiService.getUserDetail(it)
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
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }

//        try {
//            val response = apiService.getUserDetail(userPreference.getUserToken())
//            if (response.isSuccessful) {
//                val body = response.body()
//                if (body != null) {
//                    emit(Result.Success(body))
//                } else {
//                    emit(Result.Error("Something went wrong"))
//                }
//            } else {
//                val errorBody = response.errorBody()?.string()
//                if (!errorBody.isNullOrBlank()) {
//                    val gson = Gson()
//                    val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
//                    emit(Result.Error(errorResponse.message))
//                } else {
//                    emit(Result.Error("Something went wrong"))
//                }
//            }
//        } catch (e: Exception) {
//            emit(Result.Error(e.message.toString()))
//        }
    }

    fun getSession(): Flow<User> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    private suspend fun saveSession(user: User) {
        userPreference.saveSession(user)
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
            startedPreference: StartedPreference
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(
                    apiService,
                    userPreference,
                    startedPreference
                )
            }.also { instance = it }
    }
}