package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

) {
    Column {
        Text("Project Name")
        ProjectList()
        Text("Dashboard")
        ArticleList()
        Text("Notification")
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