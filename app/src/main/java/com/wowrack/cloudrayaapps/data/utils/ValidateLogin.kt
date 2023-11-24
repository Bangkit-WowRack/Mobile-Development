package com.wowrack.cloudrayaapps.data.utils

import android.util.Log
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.pref.KeyPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

suspend fun validateLogin(
    apiService: ApiService,
    userPreference: UserPreference,
    keyPreference: KeyPreference,
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
