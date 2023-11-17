package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wowrack.cloudrayaapps.data.repository.ArticleRepository
import com.wowrack.cloudrayaapps.data.repository.ServerRepository

//@HiltViewModel
class HomeViewModel (
    private val serverRepository: ServerRepository,
    private val articleRepository: ArticleRepository
) : ViewModel() {
//    private val user = mutableStateOf(UiState<>)

//    private val _cocktailsData = mutableStateOf<UiState<CocktailsResponse>>(UiState.Loading)
//    val cocktailsData: State<UiState<CocktailsResponse>>
//        get() = _cocktailsData
}