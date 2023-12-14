package com.wowrack.cloudrayaapps.ui.screen.setting

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.FirebaseRepository
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.data.common.Result

class SettingViewModel(
    private val repository: FirebaseRepository
) : ViewModel() {

    private val _subscribeStatus = mutableStateOf<UiState<Boolean>>(UiState.Loading)
    val subscribeStatus: State<UiState<Boolean>>
        get() = _subscribeStatus

    fun subscribeNotification() {
        repository.subscribeNotification().observeForever {
            when (it) {
                is Result.Loading -> {
                    _subscribeStatus.value = UiState.Loading
                }
                is Result.Success -> {
                    _subscribeStatus.value = UiState.Success(it.data)
                }
                is Result.Error -> {
                    _subscribeStatus.value = UiState.Error(it.error)
                }
                is Result.NotLogged -> {
                    _subscribeStatus.value = UiState.NotLogged
                }
            }
        }
    }

}