package com.wowrack.cloudrayaapps.ui.screen.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.ArticleData
import com.wowrack.cloudrayaapps.data.model.ArticlesResponse
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class NewsViewModel(
    private val newsRepository: ArticleRepository
) : ViewModel() {

    private val _articleData = mutableStateOf<UiState<ArticleData>>(UiState.Loading)
    val articleData: State<UiState<ArticleData>>
        get() = _articleData

    fun getArticleData(id: Int) {
        newsRepository.getArticleDetail(id).observeForever {
            when (it) {
                is Result.Loading -> _articleData.value = UiState.Loading
                is Result.Success -> _articleData.value = UiState.Success(it.data)
                is Result.Error -> _articleData.value = UiState.Error(it.error)
                is Result.NotLogged -> _articleData.value = UiState.NotLogged
            }
        }
    }
}