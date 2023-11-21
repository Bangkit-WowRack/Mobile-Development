package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class ResourceViewModel (
    private val repository: ServerRepository
) : ViewModel() {

    private val _profileData = mutableStateOf<UiState<VirtualMachinesResponse>>(UiState.Loading)
    val profileData: UiState<VirtualMachinesResponse>
        get() = _profileData.value

    fun getVMList() {
        repository.getVMList().observeForever {
            when (it) {
                is Result.Loading -> _profileData.value = UiState.Loading
                is Result.Success -> _profileData.value = UiState.Success(it.data)
                is Result.Error -> _profileData.value = UiState.Error(it.error)
            }
        }
    }
}