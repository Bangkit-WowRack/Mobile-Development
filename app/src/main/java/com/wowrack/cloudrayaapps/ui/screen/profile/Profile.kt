package com.wowrack.cloudrayaapps.ui.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    ProfileContent()
}

@Composable
fun ProfileContent(

) {

}

@Preview
@Composable
fun ProfileScreenPreview() {
    CloudRayaAppsTheme {
        ProfileScreen()
    }
}