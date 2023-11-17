package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.repository.ServerRepository

//@HiltViewModel
class HomeViewModel (
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) : ViewModel() {
}