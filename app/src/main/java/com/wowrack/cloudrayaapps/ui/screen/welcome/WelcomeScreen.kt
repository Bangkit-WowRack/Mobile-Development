package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.data.common.Result
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
        }
        is UiState.Success -> {
            navigateToHome()
        }
        is UiState.NotLogged -> {
            navigateToLogin()
        }
        is UiState.Error -> {
            navigateToLogin()
        }
    }
}