package com.wowrack.cloudrayaapps.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.wowrack.cloudrayaapps.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreference private constructor(private val userDataStore: DataStore<Preferences>) {

    suspend fun saveSession(user: User) {
        userDataStore.edit { preferences ->
            preferences[bearerToken] = user.bearerToken!!
            preferences[username] = user.username!!
            preferences[expiredAt] = user.expiredAt!!
            preferences[timezone] = user.timezone!!
            preferences[refreshToken] = user.refreshToken!!
        }
    }

    fun getSession(): Flow<User> {
        return userDataStore.data.map { preferences ->
            User(
                needOtp = false,
                bearerToken = preferences[bearerToken] ?: "",
                username = preferences[username] ?: "",
                expiredAt = preferences[expiredAt] ?: "",
                timezone = preferences[timezone] ?: "",
                refreshToken = preferences[refreshToken] ?: "",
            )
        }
    }

    fun getToken() = userDataStore.data.map { preferences ->
        preferences[bearerToken]
    }

    fun getExpiredAt() = userDataStore.data.map { preferences ->
        preferences[expiredAt]
    }

    fun getRefreshToken() = userDataStore.data.map { preferences ->
        preferences[refreshToken]
    }

    suspend fun logout() {
        userDataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val bearerToken = stringPreferencesKey("bearerToken")
        private val username = stringPreferencesKey("username")
        private val expiredAt = stringPreferencesKey("expiredAt")
        private val timezone = stringPreferencesKey("timezone")
        private val refreshToken = stringPreferencesKey("refreshToken")


        fun getInstance(userDataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(userDataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}