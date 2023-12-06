package com.wowrack.cloudrayaapps.ui.screen.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.ui.common.UiState
import kotlinx.coroutines.launch

class ProfileViewModel (
    private val repository: UserRepository
) : ViewModel() {

    private val _profileData = mutableStateOf<UiState<UserDetailResponse>>(UiState.Loading)
    val profileData: State<UiState<UserDetailResponse>>
        get() = _profileData

    init {
        getProfileData()
    }

    fun getProfileData() {
        repository.getUserDetail().observeForever {
            when (it) {
                is Result.Loading -> _profileData.value = UiState.Loading
                is Result.Success -> _profileData.value = UiState.Success(it.data)
                is Result.Error -> _profileData.value = UiState.Error(it.error)
                is Result.NotLogged -> _profileData.value = UiState.NotLogged
            }
        }
    }

    fun logout () {
        viewModelScope.launch {
            repository.logout()
        }
    }
}