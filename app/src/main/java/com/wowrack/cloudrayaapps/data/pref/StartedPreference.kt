package com.wowrack.cloudrayaapps.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.startDataStore: DataStore<Preferences> by preferencesDataStore(name = "started")

class StartedPreference private constructor(private val startDataStore: DataStore<Preferences>) {

    suspend fun saveSession() {
        startDataStore.edit { preferences ->
            preferences[isNew] = "true"
        }
    }

    fun isFirstOpen(): Boolean {
        return runBlocking {
            startDataStore.data.map { preferences ->
                preferences[isNew]
            }.first()
        } != null
    }

    companion object {
        @Volatile
        private var INSTANCE: StartedPreference? = null

        private val isNew = stringPreferencesKey("isNew")

        fun getInstance(startDataStore: DataStore<Preferences>): StartedPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = StartedPreference(startDataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}