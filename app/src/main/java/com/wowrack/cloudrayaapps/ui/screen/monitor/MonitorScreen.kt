package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun MonitorScreen(
    modifier: Modifier = Modifier,
) {
    MonitorContent()
}

@Composable
fun MonitorContent(

) {

}

@Preview
@Composable
fun MonitorScreenPreview() {
    CloudRayaAppsTheme {
        MonitorScreen()
    }
}