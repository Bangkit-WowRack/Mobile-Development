package com.wowrack.cloudrayaapps.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.settingData: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getThemeSetting(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[theme] ?: false
        }
    }

    fun getNotificationSetting(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[notification] ?: false
        }
    }

    fun getBiometricSetting(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[biometric] ?: false
        }
    }

    suspend fun saveThemeSetting(isDarkModeActive: Boolean) {
        dataStore.edit { preferences ->
            preferences[theme] = isDarkModeActive
        }
    }

    suspend fun saveNotificationSetting(isNotificationActive: Boolean) {
        dataStore.edit { preferences ->
            preferences[notification] = isNotificationActive
        }
    }

    suspend fun saveBiometricSetting(isBiometricActive: Boolean) {
        dataStore.edit { preferences ->
            preferences[biometric] = isBiometricActive
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: SettingPreferences? = null

        private val theme = booleanPreferencesKey("theme_setting")
        private val notification = booleanPreferencesKey("notification_setting")
        private val biometric = booleanPreferencesKey("biometric_setting")

        fun getInstance(dataStore: DataStore<Preferences>): SettingPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = SettingPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}