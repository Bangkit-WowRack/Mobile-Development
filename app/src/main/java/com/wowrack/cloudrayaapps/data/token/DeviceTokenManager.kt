package com.wowrack.cloudrayaapps.data.token

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

object DeviceTokenManager {

    private const val DEVICE_TOKEN_PREF_KEY = "device_token"
    private lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    fun getDeviceToken(): String {
        val savedToken = sharedPreferences.getString(DEVICE_TOKEN_PREF_KEY, null)
        return savedToken ?: generateAndSaveToken()
    }

    private fun generateAndSaveToken(): String {
        val newToken = UUID.randomUUID().toString()
        sharedPreferences.edit().putString(DEVICE_TOKEN_PREF_KEY, newToken).apply()
        return newToken
    }
}