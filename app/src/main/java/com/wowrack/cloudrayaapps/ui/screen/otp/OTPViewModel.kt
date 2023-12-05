package com.wowrack.cloudrayaapps.ui.screen.otp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import com.wowrack.cloudrayaapps.data.common.Result
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.ui.common.UiState

class OTPViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _otpStatus = mutableStateOf<UiState<Boolean>>(UiState.Loading)
    val otpStatus: State<UiState<Boolean>>
        get() = _otpStatus

    private val _otpToken = mutableStateOf<UiState<String>>(UiState.Loading)
    val otpToken: State<UiState<String>>
        get() = _otpToken

    fun verifyOTP(otp: String, verifyOTPToken: String, key: Key) {
        userRepository.verifyOTP(otp, verifyOTPToken, key).observeForever {
            when (it) {
                is Result.Loading -> {
                    _otpStatus.value = UiState.Loading
                }
                is Result.Success -> {
                    _otpStatus.value = UiState.Success(it.data)
                }
                is Result.Error -> {
                    _otpStatus.value = UiState.Error(it.error)
                }
                is Result.NotLogged -> {
                    _otpStatus.value = UiState.NotLogged
                }
            }
        }
    }

    fun getOTP(otpRequestToken: String) {
        userRepository.getOTP(otpRequestToken).observeForever {
            when (it) {
                is Result.Loading -> {
                    _otpToken.value = UiState.Loading
                }
                is Result.Success -> {
                    _otpToken.value = UiState.Success(it.data)
                }
                is Result.Error -> {
                    _otpToken.value = UiState.Error(it.error)
                }
                is Result.NotLogged -> {
                    _otpToken.value = UiState.NotLogged
                }
            }
        }
    }
}