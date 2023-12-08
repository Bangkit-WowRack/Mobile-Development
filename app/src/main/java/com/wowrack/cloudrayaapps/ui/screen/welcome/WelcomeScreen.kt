package com.wowrack.cloudrayaapps.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

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

    Column(
        modifier = Modifier
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
}