package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun ResourceScreen(
    modifier: Modifier = Modifier,
//    viewModel: ResourceViewModel = hiltViewModel()
) {
    ResourceContent()
}

@Composable
fun ResourceContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Coming Soon",
            fontFamily = poppins,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun ResourceScreenPreview() {
    CloudRayaAppsTheme {
        ResourceScreen()
    }
}