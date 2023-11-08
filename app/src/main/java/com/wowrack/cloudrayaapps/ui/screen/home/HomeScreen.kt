package com.wowrack.cloudrayaapps.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview
@Composable
fun HomeScreenPreview() {
    CloudRayaAppsTheme {
        HomeScreen()
    }
}