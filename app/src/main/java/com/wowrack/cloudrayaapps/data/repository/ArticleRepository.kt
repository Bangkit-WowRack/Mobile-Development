package com.wowrack.cloudrayaapps.data.repository

import androidx.lifecycle.liveData
import com.wowrack.cloudrayaapps.data.api.ApiService
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.dummy.getDummyArticleResponse
import kotlinx.coroutines.Dispatchers

class ArticleRepository private constructor(
    private val apiService: ApiService,
) {

    fun getArticles() = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            emit(Result.Success(getDummyArticleResponse()))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getArticleDetail(id: Int) = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val data = getDummyArticleResponse().data?.first { it.id == id }
            if (data != null) {
                emit(Result.Success(data))
            } else {
                emit(Result.Error("Data not found"))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

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