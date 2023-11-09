package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.ui.components.ArticleList
import com.wowrack.cloudrayaapps.ui.components.NotificationList
import com.wowrack.cloudrayaapps.ui.components.ProjectList
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    HomeContent()
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement =  Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Project",
            fontSize = 16.sp,
        )
        ProjectList()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Dashboard",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        ArticleList()
        Text(
            text = "Notification",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        NotificationList()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CloudRayaAppsTheme {
        HomeScreen()
    }
}