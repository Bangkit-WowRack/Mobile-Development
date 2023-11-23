package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.runtime.Composable
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
) {
    val isLogin by viewModel.isLogin

    when (isLogin) {
        is UiState.Loading -> {
            // Loading()
        }
        is UiState.Success -> {
            when((isLogin as UiState.Success<Boolean>).data) {
                true -> {
                    navigateToHome()
                }
                false -> {
                    navigateToLogin()
                }
            }
        }
        is UiState.Error -> {
            // Error(message = (isLogin as UiState.Error).message, onRetry = onRetry)
        }
    }
}