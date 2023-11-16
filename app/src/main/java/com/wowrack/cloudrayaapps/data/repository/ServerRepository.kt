package com.wowrack.cloudrayaapps.data.repository

import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import javax.inject.Inject

class ServerRepository @Inject constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
) {

    companion object {
        @Volatile
        private var instance: ServerRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService,
        ): ServerRepository =
            instance ?: synchronized(this) {
                instance ?: ServerRepository(userPreference, apiService)
            }.also { instance = it }
    }
}