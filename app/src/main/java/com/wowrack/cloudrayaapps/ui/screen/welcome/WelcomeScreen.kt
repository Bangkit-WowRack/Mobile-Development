package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import kotlinx.coroutines.delay

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

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.cloudraya_login_logo),
            contentDescription = "image",
            Modifier.size(150.dp)
        )
    }

    LaunchedEffect(isLogin) {
        delay(1500)
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

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    WelcomeScreen(
        navigateToLogin = {},
        navigateToHome = {},
        navigateToStarted = {}
    )
}