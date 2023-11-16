package com.wowrack.cloudrayaapps.ui.screen.server

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServerViewModel @Inject constructor(
    private val repository: ServerRepository
) : ViewModel() {
}