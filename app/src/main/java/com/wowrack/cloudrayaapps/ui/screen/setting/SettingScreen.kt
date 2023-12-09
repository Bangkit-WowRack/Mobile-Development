package com.wowrack.cloudrayaapps.ui.screen.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.accompanist.permissions.rememberPermissionState
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold
import kotlinx.coroutines.Job

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SettingScreen(
    themeSetting: Boolean,
    notificationSetting: Boolean,
    biometricSetting: Boolean,
    changeThemeSetting: (Boolean) -> Unit,
    changeNotificationSetting: (Boolean) -> Unit,
    changeBiometricSetting: (Boolean) -> Unit,
    showSnackBar: (String) -> Job,
) {

    if (notificationSetting) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            val permissionState =
                rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
            val launcher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
                    if (isGranted) {
                        showSnackBar("Permission Granted")
                    } else {
                        changeNotificationSetting(false)
                    }
                }
            if (!permissionState.hasPermission) {
                launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Setting",
            fontFamily = poppinsBold,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "Reminder",
                fontFamily = poppinsBold,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Notification",
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Switch(
                    modifier = Modifier.size(50.dp),
                    checked = notificationSetting,
                    onCheckedChange = changeNotificationSetting
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Security",
                fontFamily = poppinsBold,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Biometric Authentication",
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Switch(
                    modifier = Modifier.size(50.dp),
                    checked = biometricSetting,
                    onCheckedChange = changeBiometricSetting
                )
            }
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Display",
                fontFamily = poppinsBold,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dark Mode",
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Switch(
                    modifier = Modifier.size(50.dp),
                    checked = themeSetting,
                    onCheckedChange = changeThemeSetting
                )
            }
        }
    }
}