package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToStarted: () -> Unit,
) {
    val isLogin by viewModel.isLogin

    LaunchedEffect(isLogin) {
        when (isLogin) {
            is UiState.Success -> {
                navigateToHome()
            }
            is UiState.NotLogged -> {
                if (viewModel.isStarted()) {
                    navigateToStarted()
                } else {
                    navigateToLogin()
                }
            }
            is UiState.Error -> {
                navigateToLogin()
            }
            is UiState.Loading -> {
                // do nothing
            }
        }
    }
}