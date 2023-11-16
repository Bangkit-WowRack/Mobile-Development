package com.wowrack.cloudrayaapps.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
}