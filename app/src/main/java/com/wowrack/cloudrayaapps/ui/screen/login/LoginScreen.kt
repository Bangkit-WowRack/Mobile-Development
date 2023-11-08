package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    LoginContent()
}

@Composable
fun LoginContent(

) {

}

@Preview
@Composable
fun LoginScreenPreview() {
    CloudRayaAppsTheme {
        LoginScreen()
    }
}