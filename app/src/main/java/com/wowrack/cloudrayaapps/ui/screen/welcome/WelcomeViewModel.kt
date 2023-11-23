package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.ui.common.UiState
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    val isLogin = mutableStateOf<UiState<Boolean>>(UiState.Loading)

    init {
        isLogin()
    }

    private fun isLogin() = viewModelScope.launch {
        try {
            val login = userRepository.isLogin()
            isLogin.value = UiState.Success(login)
        } catch (e: Exception) {
            isLogin.value = UiState.Error(e.message.toString())
        }
    }
}