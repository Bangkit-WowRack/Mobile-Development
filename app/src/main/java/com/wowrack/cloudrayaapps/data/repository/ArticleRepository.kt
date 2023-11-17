package com.wowrack.cloudrayaapps.data.repository

import com.wowrack.cloudrayaapps.data.api.ApiService

class ArticleRepository (
    private val apiService: ApiService,
) {

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): ArticleRepository =
            instance ?: synchronized(this) {
                instance ?: ArticleRepository(apiService)
            }.also { instance = it }
    }
}