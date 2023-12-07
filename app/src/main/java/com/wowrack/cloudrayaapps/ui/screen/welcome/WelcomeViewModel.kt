package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.data.common.Result
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val repository: UserRepository,
) : ViewModel() {

    val isLogin = mutableStateOf<UiState<Boolean>>(UiState.Loading)

    init {
        isLogin()
    }

    private fun isLogin() {
        repository.isLoggedIn().observeForever {
            when (it) {
                is Result.Loading -> isLogin.value = UiState.Loading
                is Result.Success -> isLogin.value = UiState.Success(it.data)
                is Result.Error -> isLogin.value = UiState.Error(it.error)
                is Result.NotLogged -> isLogin.value = UiState.NotLogged
            }
        }
    }

    fun isStarted() = repository.isStarted()
}