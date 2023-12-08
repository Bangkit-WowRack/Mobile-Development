package com.wowrack.cloudrayaapps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wowrack.cloudrayaapps.data.repository.SettingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val settingRepository: SettingRepository
) : ViewModel() {

    private val _themeSetting: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val themeSetting: MutableStateFlow<Boolean>
        get() = _themeSetting

    private val _notificationSetting: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val notificationSetting: MutableStateFlow<Boolean>
        get() = _notificationSetting

    private val _biometricSetting: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val biometricSetting: MutableStateFlow<Boolean>
        get() = _biometricSetting

    init {
        getThemeSetting()
        getNotificationSetting()
        getBiometricSetting()
    }

    private fun getThemeSetting() {
        viewModelScope.launch {
            settingRepository.getThemeSetting()
                .collect { isDarkModeActive ->
                    _themeSetting.value = isDarkModeActive
                }
        }
    }

    private fun getNotificationSetting() {
        viewModelScope.launch {
            settingRepository.getNotificationSetting()
                .collect { isNotificationActive ->
                    _notificationSetting.value = isNotificationActive
                }
        }
    }

    fun getBiometricSetting() {
        viewModelScope.launch {
            settingRepository.getBiometricSetting()
                .collect { isBiometricActive ->
                    _biometricSetting.value = isBiometricActive
                }
        }
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            settingRepository.saveThemeSetting(isDarkModeActive)
        }
    }

    fun saveNotificationSetting(isNotificationActive: Boolean) {
        viewModelScope.launch {
            settingRepository.saveNotificationSetting(isNotificationActive)
        }
    }

    fun saveBiometricSetting(isBiometricActive: Boolean) {
        viewModelScope.launch {
            settingRepository.saveBiometricSetting(isBiometricActive)
        }
    }
}