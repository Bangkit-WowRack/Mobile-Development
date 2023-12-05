package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.ActionVMResponse
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.VMAction
import com.wowrack.cloudrayaapps.data.model.VMDetailResponse
import com.wowrack.cloudrayaapps.ui.common.UiState

class MonitorViewModel (
    private val repository: ServerRepository
) : ViewModel() {
    private val _usageData = mutableStateOf<UiState<UsageResponse>>(UiState.Loading)
    val usageData: State<UiState<UsageResponse>>
        get() = _usageData

    private val _bandwidthData = mutableStateOf<UiState<BandwidthResponse>>(UiState.Loading)
    val bandwidthData: State<UiState<BandwidthResponse>>
        get() = _bandwidthData

    private val _vmDetail = mutableStateOf<UiState<VMDetailResponse>>(UiState.Loading)
    val vmDetail: State<UiState<VMDetailResponse>>
        get() = _vmDetail

    private val _actionVMStatus = mutableStateOf<UiState<ActionVMResponse>>(UiState.Loading)
    val actionVMStatus: State<UiState<ActionVMResponse>>
        get() = _actionVMStatus

    fun getUsageData(id: Int) {
        repository.getVMUsage(id).observeForever {
            when (it) {
                is Result.Loading -> _usageData.value = UiState.Loading
                is Result.Success -> _usageData.value = UiState.Success(it.data)
                is Result.Error -> _usageData.value = UiState.Error(it.error)
                is Result.NotLogged -> _usageData.value = UiState.NotLogged
            }
        }
    }

    fun getBandwidthData(id: Int) {
        repository.getVMBandwidth(id).observeForever {
            when (it) {
                is Result.Loading -> _bandwidthData.value = UiState.Loading
                is Result.Success -> _bandwidthData.value = UiState.Success(it.data)
                is Result.Error -> _bandwidthData.value = UiState.Error(it.error)
                is Result.NotLogged -> _bandwidthData.value = UiState.NotLogged
            }
        }
    }

    fun getVMDetail(id: Int) {
        repository.getVMDetail(id).observeForever {
            when (it) {
                is Result.Loading -> _vmDetail.value = UiState.Loading
                is Result.Success -> _vmDetail.value = UiState.Success(it.data)
                is Result.Error -> _vmDetail.value = UiState.Error(it.error)
                is Result.NotLogged -> _vmDetail.value = UiState.NotLogged
            }
        }
    }

    fun doVMAction(id: Int, action: VMAction) {
        repository.doVMAction(id, action).observeForever {
            when (it) {
                is Result.Loading -> _actionVMStatus.value = UiState.Loading
                is Result.Success -> _actionVMStatus.value = UiState.Success(it.data)
                is Result.Error -> _actionVMStatus.value = UiState.Error(it.error)
                is Result.NotLogged -> _actionVMStatus.value = UiState.NotLogged
            }
        }
    }
}