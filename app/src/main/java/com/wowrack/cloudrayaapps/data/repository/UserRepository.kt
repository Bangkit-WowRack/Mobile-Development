package com.wowrack.cloudrayaapps.data.repository

import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
) {

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService,
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }
}