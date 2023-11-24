package com.wowrack.cloudrayaapps.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.outlined.AppBlocking
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
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

    var appKey by remember { mutableStateOf("") }
    var secretKey by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.cloudraya_login_logo),
                contentDescription = "dummy logo",
                modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Login",
                fontFamily = poppins,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = appKey,
                onValueChange = { appKey = it },
                leadingIcon = { Icon(imageVector = InputType.AppKey.icon, null) },
                placeholder = { Text(text = InputType.AppKey.label, fontFamily = poppins) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = secretKey,
                onValueChange = { secretKey = it },
                leadingIcon = { Icon(imageVector = InputType.SecretKey.icon, null) },
                placeholder = { Text(text = InputType.SecretKey.label, fontFamily = poppins) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            when (loginStatus) {
                is UiState.Loading -> {

                }

                is UiState.Success -> {
                    navigateToHome()
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
            }
            Button(
                onClick = { onLogin(appKey, secretKey) },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(20.dp),
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                } else {
                    Text(
                        text = "Login",
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.DarkGray,
                        fontFamily = poppins
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
        LoginScreen({})
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