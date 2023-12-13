package com.wowrack.cloudrayaapps

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import com.wowrack.cloudrayaapps.data.token.DeviceTokenManager
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DeviceTokenManager.initialize(applicationContext)

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }

            val token = task.result

            Log.d("ayam", token)
        })

        setContent {
            val viewModel: AppViewModel = viewModel(
                factory = getViewModelFactory(context = LocalContext.current)
            )

            val themeSetting by viewModel.themeSetting.collectAsState()
            val notificationSetting by viewModel.notificationSetting.collectAsState()
            val biometricSetting by viewModel.biometricSetting.collectAsState()

            val changeThemeSetting = { isDarkModeActive: Boolean ->
                viewModel.saveThemeSetting(isDarkModeActive)
            }

            val changeNotificationSetting = { isNotificationActive: Boolean ->
                viewModel.saveNotificationSetting(isNotificationActive)
            }

            val changeBiometricSetting = { isBiometricActive: Boolean ->
                viewModel.saveBiometricSetting(isBiometricActive)
            }

            CloudRayaAppsTheme(darkTheme = themeSetting) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        themeSetting = themeSetting,
                        notificationSetting = notificationSetting,
                        biometricSetting = biometricSetting,
                        changeThemeSetting = changeThemeSetting,
                        changeNotificationSetting = changeNotificationSetting,
                        changeBiometricSetting = changeBiometricSetting
                    )
                }
            }
        }
    }
}