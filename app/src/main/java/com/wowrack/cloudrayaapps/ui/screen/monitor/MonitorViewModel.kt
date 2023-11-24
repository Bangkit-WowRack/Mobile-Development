package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.ui.common.UiState

class MonitorViewModel (
    private val repository: ServerRepository
) : ViewModel() {
    private val _usageData = mutableStateOf<UiState<UsageResponse>>(UiState.Loading)
    val usageData: UiState<UsageResponse>
        get() = _usageData.value

    private val _bandwidthData = mutableStateOf<UiState<BandwidthResponse>>(UiState.Loading)
    val bandwidthData: UiState<BandwidthResponse>
        get() = _bandwidthData.value

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
}