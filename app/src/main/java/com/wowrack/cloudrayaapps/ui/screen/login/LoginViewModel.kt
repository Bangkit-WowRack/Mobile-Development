package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.model.DashboardResponse
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.ui.common.UiState

class LoginViewModel (
    private val repository: UserRepository
) : ViewModel() {

    private val _loginStatus = mutableStateOf<UiState<Boolean>>(UiState.Loading)
    val loginStatus: State<UiState<Boolean>>
        get() = _loginStatus

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean>
        get() = _isLoading

    fun login (appKey: String, secretKey: String) {
        repository.login(appKey, secretKey).observeForever {
            when (it) {
                is Result.Loading -> {
                    _loginStatus.value = UiState.Loading
                    _isLoading.value = true
                }
                is Result.Success -> {
                    _loginStatus.value = UiState.Success(it.data)
                    _isLoading.value = false
                }
                is Result.Error -> {
                    _loginStatus.value = UiState.Error(it.error)
                    _isLoading.value = false
                }
                is Result.NotLogged -> {
                    _loginStatus.value = UiState.NotLogged
                    _isLoading.value = false
                }
            }
        }
    }

    fun isStarted() = repository.isStarted()
}