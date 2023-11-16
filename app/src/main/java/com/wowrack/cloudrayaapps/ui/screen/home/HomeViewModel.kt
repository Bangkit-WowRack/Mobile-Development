package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.repository.ServerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) : ViewModel() {
}