package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun ResourceScreen(
    modifier: Modifier = Modifier,
) {
    ResourceContent()
}

@Composable
fun ResourceContent(

) {

}

@Preview
@Composable
fun ResourceScreenPreview() {
    CloudRayaAppsTheme {
        ResourceScreen()
    }
}