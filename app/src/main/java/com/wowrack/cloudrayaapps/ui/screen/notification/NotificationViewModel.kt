package com.wowrack.cloudrayaapps.ui.screen.notification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.data.model.NotificationResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class NotificationViewModel(
    private val serverRepository: ServerRepository,
) : ViewModel() {

    private val _notificationList = mutableStateOf<UiState<NotificationResponse>>(UiState.Loading)
    val notificationList: State<UiState<NotificationResponse>>
        get() = _notificationList

    fun getNotificationList() {
        serverRepository.getNotificationList().observeForever {
            when (it) {
                is Result.Loading -> _notificationList.value = UiState.Loading
                is Result.Success -> _notificationList.value = UiState.Success(it.data)
                is Result.Error -> _notificationList.value = UiState.Error(it.error)
                is Result.NotLogged -> _notificationList.value = UiState.NotLogged
            }
        }
    }
}