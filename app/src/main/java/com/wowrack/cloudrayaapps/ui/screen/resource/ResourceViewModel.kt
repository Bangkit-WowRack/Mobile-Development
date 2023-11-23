package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.VirtualMachinesResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.ui.common.UiState

class ResourceViewModel (
    private val repository: ServerRepository
) : ViewModel() {

    private val _vmListData = mutableStateOf<UiState<VirtualMachinesResponse>>(UiState.Loading)
    val vmListData: State<UiState<VirtualMachinesResponse>>
        get() = _vmListData

    init {
        getVMList()
    }

    private fun getVMList() {
        repository.getVMList().observeForever {
            when (it) {
                is Result.Loading -> _vmListData.value = UiState.Loading
                is Result.Success -> _vmListData.value = UiState.Success(it.data)
                is Result.Error -> _vmListData.value = UiState.Error(it.error)
            }
        }
    }
}