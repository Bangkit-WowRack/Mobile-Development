package com.wowrack.cloudrayaapps.ui.screen.server

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun ServerScreen(
    modifier: Modifier = Modifier,
) {
    ServerContent()
}

@Composable
fun ServerContent(

) {

}

@Preview
@Composable
fun ServerScreenPreview() {
    CloudRayaAppsTheme {
        ServerScreen()
    }
}