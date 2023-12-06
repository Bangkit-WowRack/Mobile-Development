package com.wowrack.cloudrayaapps.ui.screen.server

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class ServerViewModel (
    private val repository: ServerRepository
) : ViewModel() {

    private val _sshUrl = mutableStateOf<UiState<String>>(UiState.Loading)
    val sshUrl: State<UiState<String>>
        get() = _sshUrl

    fun getSshUrl(id: Int) {
        repository.openConsole(id).observeForever {
            when (it) {
                is Result.Loading -> _sshUrl.value = UiState.Loading
                is Result.Success -> _sshUrl.value = UiState.Success(it.data)
                is Result.Error -> _sshUrl.value = UiState.Error(it.error)
                is Result.NotLogged -> _sshUrl.value = UiState.NotLogged
            }
        }
    }
}