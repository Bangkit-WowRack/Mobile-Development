package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import org.junit.Before
import org.junit.Rule

class LoginScreenKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CloudRayaAppsTheme {
                LoginScreen(
                    {}, {_ , _ -> }
                )
            }
        }
    }



}