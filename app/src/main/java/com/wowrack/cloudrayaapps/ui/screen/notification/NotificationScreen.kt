package com.wowrack.cloudrayaapps.ui.screen.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.data.dummy.getDummyNotification
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.components.NotificationList
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@Composable
fun NotificationScreen(
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NotificationViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {

    val notificationList by viewModel.notificationList

    LaunchedEffect(key1 = true) {
        viewModel.getNotificationList()
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = "Notification",
            fontFamily = poppinsBold,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(16.dp))

        when (notificationList) {
            is UiState.Loading -> {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        16.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                NotificationList(data = (notificationList as UiState.Success).data.data)
            }

            is UiState.Error -> {
                ErrorMessage(message = (notificationList as UiState.Error).errorMessage,
                    onRetry = { viewModel.getNotificationList() }
                )
            }

            is UiState.NotLogged -> {
                navigateToLogin()
            }
        }
    }
}
