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
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        LoginContent(navigateToHome)
    }
}

@Composable
fun LoginContent(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
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
        TextInput(InputType.AppKey)
        TextInput(InputType.SecretKey)
//        TextInput(InputType.ApiUrl)
//        TextInput(InputType.AppName)
        Button(
            onClick = navigateToHome,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text("Login", Modifier.padding(vertical = 8.dp), Color.DarkGray, fontFamily = poppins)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(inputType: InputType) {
    var value:String by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {value = it},
        leadingIcon = { Icon(imageVector = inputType.icon , null )},
        placeholder = { Text(text = inputType.label, fontFamily = poppins)},
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )

    )
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
    object AppKey: InputType(
        label = "App Key",
        icon = Icons.Outlined.Key,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object SecretKey: InputType(
        label = "Secret Key",
        icon = Icons.Outlined.Lock,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object ApiUrl: InputType(
        label = "API Url",
        icon = Icons.Outlined.Web,
        KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object AppName: InputType(
        label = "App Name",
        icon = Icons.Outlined.Smartphone,
        KeyboardOptions(imeAction = ImeAction.Done),
        visualTransformation = VisualTransformation.None
    )

}