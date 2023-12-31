package com.wowrack.cloudrayaapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.dummy.getDummyNotification
import com.wowrack.cloudrayaapps.data.model.ActionVMRequest
import com.wowrack.cloudrayaapps.data.model.ActionVMResponse
import com.wowrack.cloudrayaapps.data.model.BandwidthRequest
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.ConsoleRequest
import com.wowrack.cloudrayaapps.data.model.ConsoleResponse
import com.wowrack.cloudrayaapps.data.model.ErrorResponse
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.data.model.NotificationResponse
import com.wowrack.cloudrayaapps.data.model.UsageRequest
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.data.model.VMAction
import com.wowrack.cloudrayaapps.data.model.VMDetailResponse
import com.wowrack.cloudrayaapps.data.utils.getTokenAndValidate
import kotlinx.coroutines.Dispatchers

class ServerRepository private constructor(
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
                        if (errorResponse.code == 401) {
                            emit(Result.NotLogged)
                        } else {
                            emit(Result.Error(errorResponse.message))
                        }
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
                    if (errorResponse.code == 401) {
                            emit(Result.NotLogged)
                        } else {
                            emit(Result.Error(errorResponse.message))
                        }
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
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token == null) {
                emit(Result.NotLogged)
                return@liveData
            }

            val response = apiService.getVMUsage(token, UsageRequest(id), 1, 24)
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
                    if (errorResponse.code == 401) {
                        emit(Result.NotLogged)
                    } else {
                        emit(Result.Error(errorResponse.message))
                    }
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getVMBandwidth(id: Int): LiveData<Result<BandwidthResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token == null) {
                emit(Result.NotLogged)
                return@liveData
            }

            val response = apiService.getVMBandwidth(token, BandwidthRequest(id), 1, 12)
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
                    if (errorResponse.code == 401) {
                        emit(Result.NotLogged)
                    } else {
                        emit(Result.Error(errorResponse.message))
                    }
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun doVMAction(id: Int, action: VMAction): LiveData<Result<ActionVMResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token == null) {
                emit(Result.NotLogged)
                return@liveData
            }

            val response = apiService.actionVM(token, ActionVMRequest(id, action, false))
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
                    if (errorResponse.code == 401) {
                        emit(Result.NotLogged)
                    } else {
                        emit(Result.Error(errorResponse.message))
                    }
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun openConsole(id: Int): LiveData<Result<String>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token == null) {
                emit(Result.NotLogged)
                return@liveData
            }

            val response = apiService.openConsole(token, ConsoleRequest(id.toString()))
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(Result.Success(body.data))
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            } else {
                val errorBody = response.errorBody()?.string()
                if (!errorBody.isNullOrBlank()) {
                    val gson = Gson()
                    val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
                    if (errorResponse.code == 401) {
                        emit(Result.NotLogged)
                    } else {
                        emit(Result.Error(errorResponse.message))
                    }
                } else {
                    emit(Result.Error("Something went wrong"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getNotificationList(size: Int = 100): LiveData<Result<NotificationResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val token = getTokenAndValidate(userPreference, validateLogin)

            if (token != null) {
                val response = apiService.getNotification(token, 1, size)
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
                        if (errorResponse.code == 401) {
                            emit(Result.NotLogged)
                        } else {
                            emit(Result.Error(errorResponse.message))
                        }
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