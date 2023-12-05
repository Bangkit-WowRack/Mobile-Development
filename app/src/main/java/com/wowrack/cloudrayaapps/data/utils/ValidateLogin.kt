package com.wowrack.cloudrayaapps.data.utils

import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.model.LoginRequest
import com.wowrack.cloudrayaapps.data.pref.KeyPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.token.DeviceTokenManager
import kotlinx.coroutines.flow.first

suspend fun validateLogin(
    apiService: ApiService,
    userPreference: UserPreference,
    keyPreference: KeyPreference,
): Boolean {
    try {
        val key = keyPreference.getKey().first()
        if (key.appKey.isBlank() || key.secretKey.isBlank()) return false

        val response = apiService.login(
            LoginRequest(
                key.appKey,
                key.secretKey,
                DeviceTokenManager.getDeviceToken()
            )
        )
        response.takeIf { it.isSuccessful }?.body()?.let { body ->
            if (body.data.needOtp) return false
            userPreference.saveSession(body.data)
            return true
        }
        return false
    } catch (e: Exception) {
        return false
    }
}
