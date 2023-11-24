package com.wowrack.cloudrayaapps.data.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wowrack.cloudrayaapps.data.api.ApiConfig
import com.wowrack.cloudrayaapps.data.pref.KeyPreference
import com.wowrack.cloudrayaapps.data.pref.StartedPreference
import com.wowrack.cloudrayaapps.data.pref.UserPreference
import com.wowrack.cloudrayaapps.data.pref.keyDataStore
import com.wowrack.cloudrayaapps.data.pref.startDataStore
import com.wowrack.cloudrayaapps.data.pref.userDataStore
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.data.utils.validateLogin

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        val userPref = UserPreference.getInstance(context.userDataStore)
        val keyPref = KeyPreference.getInstance(context.keyDataStore)
        val startPref = StartedPreference.getInstance(context.startDataStore)
        val validateLogin = suspend { true }
        return UserRepository.getInstance(apiService, userPref, keyPref, startPref, validateLogin)
    }

    fun provideServerRepository(context: Context): ServerRepository {
        val apiService = ApiConfig.getApiService()
        val userPref = UserPreference.getInstance(context.userDataStore)
        val keyPref = KeyPreference.getInstance(context.keyDataStore)
        val validateLogin = suspend { validateLogin(apiService, userPref, keyPref) }
        return ServerRepository.getInstance(userPref, apiService, validateLogin)
    }

    fun provideArticleRepository() : ArticleRepository {
        val apiService = ApiConfig.getApiService()
        return ArticleRepository.getInstance(apiService)
    }

//    suspend fun provideValidateLogin(context: Context): suspend () -> Boolean {
//        val apiService = ApiConfig.getApiService()
//        val userPref = UserPreference.getInstance(context.userDataStore)
//        val keyPref = KeyPreference.getInstance(context.keyDataStore)
//        return { validateLogin(apiService, userPref, keyPref) }
//    }
}