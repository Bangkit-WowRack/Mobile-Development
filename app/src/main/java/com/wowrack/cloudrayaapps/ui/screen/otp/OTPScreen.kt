package com.wowrack.cloudrayaapps.ui.screen.otp

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.wowrack.cloudrayaapps.data.model.Key
import com.wowrack.cloudrayaapps.data.model.OTPData
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold
import kotlinx.coroutines.delay

@Composable
fun OTPScreen(
    otpToken: String,
    key: String,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: OTPViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val userKey = Gson().fromJson(key, Key::class.java)

    val otpStatus by viewModel.otpStatus

    val otpData by viewModel.otpData

    var otpValue by remember { mutableStateOf("") }
    var countdownValue by remember { mutableIntStateOf(180) }

    val minutes = countdownValue / 60
    val seconds = countdownValue % 60
    val timerText = String.format("%02d:%02d", minutes, seconds)

    val resendOtp = {
        viewModel.getOTP(otpToken)
        countdownValue = 180
    }

    LaunchedEffect(Unit) {
        viewModel.getOTP(otpToken)
        while (true) {
            if (countdownValue >= 0) {
                delay(1000)
                countdownValue--
            }
        }
    }

    LaunchedEffect(otpStatus) {
        when (otpStatus) {
            is UiState.Success -> {
                navigateToHome()
            }
            else -> {
                // do nothing
            }
        }
    }

    Surface {
        Column(
            modifier
                .padding(24.dp)
                .fillMaxSize(),
        ) {
            Column(
                modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Enter Verification Code",
                    fontFamily = poppinsBold,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Enter The OTP",
                    fontFamily = poppinsBold,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "We already send a OTP Code to your email",
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                when (otpData) {
                    is UiState.Success -> {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = (otpData as UiState.Success<OTPData>).data.email,
                            fontFamily = poppins,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                    else -> {
                        // do nothing
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                OTPTextField(
                    otpText = otpValue,
                    onOtpTextChange = { value, _ ->
                        otpValue = value
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
                when(otpStatus) {
                    is UiState.Error -> {
                        Text(
                            text = (otpStatus as UiState.Error).errorMessage,
                            fontFamily = poppins,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    else -> {
                        // do nothing
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        if (otpValue.length < 6) {
                            return@Button
                        }
                        when (otpData) {
                            is UiState.Success -> {
                                viewModel.verifyOTP(otpValue, (otpData as UiState.Success<OTPData>).data.verifyOtpToken, userKey)
                            }
                            else -> {
                                // do nothing
                            }
                        }
                    },
                    enabled = otpValue.length == 6,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        disabledContainerColor = Color.LightGray,
                    )
                ) {
                    Text(
                        text = "Verify",
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.White,
                        fontFamily = poppins
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Didn't receive the code? ",
                        color = Color.Gray,
                        fontFamily = poppins,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = if (countdownValue == 0) "Resend" else "Resend in $timerText",
                        color = if (countdownValue == 0) MaterialTheme.colorScheme.primary else Color.Gray,
                        fontFamily = poppins,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .clickable {
                                resendOtp()
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun OTPTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }

    Text(
        modifier = Modifier
            .padding(2.dp)
            .width(40.dp)
            .height(40.dp)
            .border(
                1.dp, when {
                    isFocused -> Color.DarkGray
                    else -> Color.LightGray
                }, RoundedCornerShape(8.dp)
            ),
        text = char,
        color = if (isFocused) {
            Color.LightGray
        } else {
            Color.DarkGray
        },
        textAlign = TextAlign.Center
    )
}

//@Preview
//@Composable
//fun OTPPreview() {
//    CloudRayaAppsTheme {
//        OTPScreen()
//    }
//}