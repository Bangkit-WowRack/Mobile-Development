package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.wowrack.cloudrayaapps.ui.components.LineChartList
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun MonitorScreen(
    id: String,
    modifier: Modifier = Modifier,
    viewModel: MonitorViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        MonitorContent()
    }
}

@Composable
fun MonitorContent(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(state = scrollState),
    ) {
        Text(
            text = "CPU",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LineChartList()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "GPU",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LineChartList()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Memory",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LineChartList()
    }
}

@Preview
@Composable
fun MonitorScreenPreview() {
    CloudRayaAppsTheme {
        MonitorScreen("1")
    }
}