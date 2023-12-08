package com.wowrack.cloudrayaapps.data.repository

import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.pref.SettingPreferences
import com.wowrack.cloudrayaapps.data.pref.UserPreference

class SettingRepository private constructor(
    private val settingPreferences: SettingPreferences
) {

    fun getThemeSetting() = settingPreferences.getThemeSetting()

    fun getNotificationSetting() = settingPreferences.getNotificationSetting()

    fun getBiometricSetting() = settingPreferences.getBiometricSetting()

    suspend fun saveThemeSetting(isDarkModeActive: Boolean) = settingPreferences.saveThemeSetting(isDarkModeActive)

    suspend fun saveNotificationSetting(isNotificationActive: Boolean) = settingPreferences.saveNotificationSetting(isNotificationActive)

    suspend fun saveBiometricSetting(isBiometricActive: Boolean) = settingPreferences.saveBiometricSetting(isBiometricActive)

    companion object {
        @Volatile
        private var instance: SettingRepository? = null
        fun getInstance(
            settingPreferences: SettingPreferences
        ): SettingRepository =
            instance ?: synchronized(this) {
                instance ?: SettingRepository(
                    settingPreferences
                )
            }.also { instance = it }
    }
}