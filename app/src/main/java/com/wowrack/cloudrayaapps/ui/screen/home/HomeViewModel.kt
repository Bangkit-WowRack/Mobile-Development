package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.ArticlesResponse
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.data.model.NotificationResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class HomeViewModel(
    private val userRepository: UserRepository,
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) : ViewModel() {

    private val _dashboardData = mutableStateOf<UiState<DashboardResponse>>(UiState.Loading)
    val dashboardData: State<UiState<DashboardResponse>>
        get() = _dashboardData

    private val _notificationList = mutableStateOf<UiState<NotificationResponse>>(UiState.Loading)
    val notificationList: State<UiState<NotificationResponse>>
        get() = _notificationList

    private val _articleData = mutableStateOf<UiState<ArticlesResponse>>(UiState.Loading)
    val articleData: State<UiState<ArticlesResponse>>
        get() = _articleData

//    init {
//        getDashboardData()
//        getArticleData()
//    }

    fun getDashboardData() {
        userRepository.getUserDashboard().observeForever {
            when (it) {
                is Result.Loading -> _dashboardData.value = UiState.Loading
                is Result.Success -> _dashboardData.value = UiState.Success(it.data)
                is Result.Error -> _dashboardData.value = UiState.Error(it.error)
                is Result.NotLogged -> _dashboardData.value = UiState.NotLogged
            }
        }
    }

    fun getArticleData() {
        articleRepository.getArticles().observeForever {
            when (it) {
                is Result.Loading -> _articleData.value = UiState.Loading
                is Result.Success -> _articleData.value = UiState.Success(it.data)
                is Result.Error -> _articleData.value = UiState.Error(it.error)
                is Result.NotLogged -> _articleData.value = UiState.NotLogged
            }
        }
    }

    fun getNotificationList() {
        serverRepository.getNotificationList(3).observeForever {
            when (it) {
                is Result.Loading -> _notificationList.value = UiState.Loading
                is Result.Success -> _notificationList.value = UiState.Success(it.data)
                is Result.Error -> _notificationList.value = UiState.Error(it.error)
                is Result.NotLogged -> _notificationList.value = UiState.NotLogged
            }
        }
    }
}