package com.wowrack.cloudrayaapps.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.keyDataStore: DataStore<Preferences> by preferencesDataStore(name = "key")

class KeyPreference private constructor(private val keyDataStore: DataStore<Preferences>) {

    suspend fun saveKey(key: Key) {
        keyDataStore.edit { preferences ->
            preferences[appKey] = key.appKey
            preferences[secretKey] = key.secretKey
        }
    }

    suspend fun deleteKey() {
        keyDataStore.edit { preferences ->
            preferences.clear()
        }
    }

    fun getKey(): Flow<Key> {
        return keyDataStore.data.map { preferences ->
            Key(
                preferences[appKey] ?: "",
                preferences[secretKey] ?: ""
            )
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: KeyPreference? = null

        private val appKey = stringPreferencesKey("appKey")
        private val secretKey = stringPreferencesKey("secretKey")

        fun getInstance(keyDataStore: DataStore<Preferences>): KeyPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = KeyPreference(keyDataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}