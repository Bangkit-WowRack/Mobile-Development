package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.material.icons.outlined.Web
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    navigateToOTP: (otp: String, key: String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val loginStatus by viewModel.loginStatus
    val isLoading by viewModel.isLoading

    val onLogin = { appKey: String, secretKey: String ->
        viewModel.login(appKey, secretKey)
    }

    var appKey by remember { mutableStateOf("30f15c6d-5350-4756-b9aa-d0606a84a2da") }
    var secretKey by remember { mutableStateOf("MgKgfgo49UK6GVTBp7hizT9mXn7Hq83w") }

    LaunchedEffect(loginStatus) {
        when (loginStatus) {
            is UiState.Success -> {
                if ((loginStatus as UiState.Success).data != "Success") {
                    navigateToOTP(
                        (loginStatus as UiState.Success).data,
                        Gson().toJson(Key(appKey, secretKey))
                    )
                } else {
                    navigateToHome()
                }
            }

            else -> {
                // do nothing
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),

    ) {
        Column(
            modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Login",
                fontFamily = poppinsBold,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Welcome! Log in using your App Key and Secret Key. Find these keys on Cludraya website for access",
                fontFamily = poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("appKey"),
                    value = appKey,
                    onValueChange = { appKey = it },
                    leadingIcon = { Icon(imageVector = InputType.AppKey.icon, null) },
                    placeholder = { Text(text = InputType.AppKey.label, fontFamily = poppins, color = Color.DarkGray) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onBackground),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("secretKey"),
                    value = secretKey,
                    onValueChange = { secretKey = it },
                    leadingIcon = { Icon(imageVector = InputType.SecretKey.icon, null) },
                    placeholder = { Text(text = InputType.SecretKey.label, fontFamily = poppins, color = Color.DarkGray) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onBackground),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            when (loginStatus) {
                is UiState.Loading -> {

                }

                is UiState.Error -> {
                    Text(
                        text = (loginStatus as UiState.Error).errorMessage,
                        modifier = Modifier.padding(vertical = 3.dp),
                        color = Color.Red,
                        fontFamily = poppins
                    )
                }

                is UiState.NotLogged -> {
                    Text(
                        text = "Something Went Wrong",
                        modifier = Modifier.padding(vertical = 3.dp),
                        color = Color.Red,
                        fontFamily = poppins
                    )
                }

                else -> {
                    // do nothing
                }
            }

            Button(
                onClick = { onLogin(appKey, secretKey) },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.LightGray,
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(20.dp),
                        color = Color.White
                    )
                } else {
                    Text(
                        text = "Login",
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    CloudRayaAppsTheme {
        LoginScreen({}, { _, _ -> })
    }
}

sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object AppKey : InputType(
        label = "App Key",
        icon = Icons.Outlined.Key,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object SecretKey : InputType(
        label = "Secret Key",
        icon = Icons.Outlined.Lock,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object ApiUrl : InputType(
        label = "API Url",
        icon = Icons.Outlined.Web,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object AppName : InputType(
        label = "App Name",
        icon = Icons.Outlined.Smartphone,
        KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )

}