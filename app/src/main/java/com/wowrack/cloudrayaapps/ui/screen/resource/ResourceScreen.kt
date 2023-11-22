package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ProjectList
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun ResourceScreen(
    navigateToMonitor: (String) -> Unit,
    navigateToServer: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ResourceViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    ResourceContent(
        navigateToMonitor,
        navigateToServer,
    )
}

@Composable
fun ResourceContent(
    navigateToMonitor: (String) -> Unit,
    navigateToServer: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "VM List",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        ProjectList()
        ProjectList()
        ProjectList()
        ProjectList()
    }
}

@Preview(showBackground = true)
@Composable
fun ResourceScreenPreview() {
    CloudRayaAppsTheme {
        ResourceScreen({}, {})
    }
}