package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.UserRepository

//@HiltViewModel
class LoginViewModel (
    private val repository: UserRepository
) : ViewModel() {
}