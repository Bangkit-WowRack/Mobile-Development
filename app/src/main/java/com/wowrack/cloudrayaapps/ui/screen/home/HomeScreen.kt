package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ArticleList
import com.wowrack.cloudrayaapps.ui.components.CardDashboardItem
import com.wowrack.cloudrayaapps.ui.components.DashboardInfo
import com.wowrack.cloudrayaapps.ui.components.NotificationList
import com.wowrack.cloudrayaapps.ui.components.ProjectList
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val dashboardData by viewModel.dashboardData
    val articleData by viewModel.articleData

    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement =  Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Dashboard",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        when (dashboardData) {
            is UiState.Loading -> {
                Text(text = "Loading")
            }
            is UiState.Success -> {
                DashboardInfo((dashboardData as UiState.Success).data.data)
            }
            is UiState.Error -> {
                Text(text = (dashboardData as UiState.Error).errorMessage)
            }
        }
        Text(
            text = "News",
            fontFamily = poppins,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        when (articleData) {
            is UiState.Loading -> {
                Text(text = "Loading")
            }
            is UiState.Success -> {
                val data = (articleData as UiState.Success).data.data
                if (data != null) {
                    ArticleList(data)
                }
            }
            is UiState.Error -> {
                Text(text = (articleData as UiState.Error).errorMessage)
            }
        }
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = "Notification",
            fontFamily = poppins,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = modifier
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            NotificationList()
        }
    }
}