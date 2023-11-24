package com.wowrack.cloudrayaapps.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.pref.StartedPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.model.ErrorResponse
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.data.pref.KeyPreference
import com.wowrack.cloudrayaapps.data.token.getUserToken
import com.wowrack.cloudrayaapps.data.token.isTokenExpired
//import com.wowrack.cloudrayaapps.data.utils.apiCallWithAuth
import com.wowrack.cloudrayaapps.data.utils.getTokenAndValidate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

class UserRepository(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
    private val keyPreference: KeyPreference,
    private val startedPreference: StartedPreference,
    private val validateLogins: suspend () -> Boolean
) {

    suspend fun validateLogin(

    ): Boolean {
        try {
            val key = keyPreference.getKey().first()

            if (key.appKey == "" || key.secretKey == "") {
                return false
            }

            val response = apiService.login(LoginRequest(key.appKey, key.secretKey))

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    userPreference.saveSession(body.data)
                    return true
                }
            }

            return false
        } catch (e: Exception) {
            return false
        }
    }

    suspend fun getTokenAndValidate(

    ): String? {
        val token = userPreference.getUserToken()
        if (token != null) {
            if (userPreference.isTokenExpired()) {
                val isValid = validateLogin()
                return if (isValid) {
                    userPreference.getUserToken()
                } else {
                    null
                }
            }
            return token
        }

        return null
    }

    fun isStarted(): Boolean = startedPreference.isStarted()

    fun isLoggedIn(): LiveData<Result<Boolean>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate()

            if (token == null) {
                emit(Result.NotLogged)
            } else {
                emit(Result.Success(true))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun login(appKey: String, secretKey: String): LiveData<Result<Boolean>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val response = apiService.login(LoginRequest(appKey, secretKey))
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        startedPreference.setStarted()
                        userPreference.saveSession(body.data)
                        keyPreference.saveKey(Key(appKey, secretKey))
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

    fun isLogin(): Boolean {
        val token = runBlocking {
            userPreference.getToken().firstOrNull()
        }
        return token != null
    }

    fun getUserDetail(): LiveData<Result<UserDetailResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate()

            if (token != null) {
                val response = apiService.getUserDetail(token)
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

    fun getUserDashboard(): LiveData<Result<DashboardResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate()

            if (token != null) {
                val response = apiService.getUserDashboard(token)
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

    suspend fun logout() {
        userPreference.logout()
        keyPreference.deleteKey()
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
            keyPreference: KeyPreference,
            startedPreference: StartedPreference,
            validateLogin: suspend () -> Boolean
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(
                    apiService,
                    userPreference,
                    keyPreference,
                    startedPreference,
                    validateLogin
                )
            }.also { instance = it }
    }
}