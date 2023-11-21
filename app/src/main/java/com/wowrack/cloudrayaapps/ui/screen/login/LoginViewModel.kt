package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.UserRepository

class LoginViewModel (
    private val repository: UserRepository
) : ViewModel() {

    fun login (appKey: String, secretKey: String) {
        repository.login(appKey, secretKey)
    }

    fun isStarted() = repository.isStarted()
}