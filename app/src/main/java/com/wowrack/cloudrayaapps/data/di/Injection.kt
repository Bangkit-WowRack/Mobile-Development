package com.wowrack.cloudrayaapps.data.di

//import android.content.Context
//import com.wowrack.cloudrayaapps.data.api.ApiConfig
//import com.wowrack.cloudrayaapps.data.pref.UserPreference
//import com.wowrack.cloudrayaapps.data.pref.dataStore
//import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
//import com.wowrack.cloudrayaapps.data.repository.ServerRepository
//import com.wowrack.cloudrayaapps.data.repository.UserRepository
//
//object Injection {
//    fun provideUserRepository(context: Context): UserRepository {
//        val apiService = ApiConfig.getApiService()
//        val pref = UserPreference.getInstance(context.dataStore)
//        return UserRepository.getInstance(pref, apiService)
//    }
//
//    fun provideServerRepository(context: Context): ServerRepository {
//        val apiService = ApiConfig.getApiService()
//        val pref = UserPreference.getInstance(context.dataStore)
//        return ServerRepository.getInstance(pref, apiService)
//    }
//
//    fun provideArticleRepository() : ArticleRepository {
//        val apiService = ApiConfig.getApiService()
//        return ArticleRepository.getInstance(apiService)
//    }
//}