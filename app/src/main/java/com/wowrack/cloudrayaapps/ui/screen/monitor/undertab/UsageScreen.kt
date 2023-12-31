package com.wowrack.cloudrayaapps.ui.screen.monitor.undertab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.components.CustomTab
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun UsageContent(
    usageData: UiState<UsageResponse>,
    bandwidthData: UiState<BandwidthResponse>,
    onUsageDataRetry : () -> Unit,
    onBandwidthDataRetry : () -> Unit,
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTab(
            modifier = Modifier.fillMaxWidth(),
            selectedItemIndex = selected,
            items = listOf("CPU", "Memory", "Bandwidth"),
            onClick = { selected = it }
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            when (selected) {
                0 -> CPUTab(
                    data = usageData,
                    onRetry = onUsageDataRetry
                )
                1 -> MemoryTab(
                    data = usageData,
                    onRetry = onUsageDataRetry
                )
                2 -> BandwidthTab(
                    data = bandwidthData,
                    onRetry = onBandwidthDataRetry
                )
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight())
    }
}
