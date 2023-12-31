package com.wowrack.cloudrayaapps.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.data.model.DetailData
import com.wowrack.cloudrayaapps.data.model.UserDetailResponse
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.shimmer.ProfileScreenShimmering
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold
import com.wowrack.cloudrayaapps.utils.getStatus

@Composable
fun ProfileScreen(
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val profileData by viewModel.profileData

    val onLogout = {
        viewModel.logout()
        navigateToLogin()
    }

    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.verticalScroll(state = scrollState),
        color = MaterialTheme.colorScheme.secondary
    ) {
        when (profileData) {
            is UiState.Loading -> {
                ProfileScreenShimmering()
            }
            is UiState.Success -> {
                ProfileContent(
                    data = (profileData as UiState.Success).data.data,
                    onLogout = onLogout
                )
            }
            is UiState.Error -> {
                ErrorMessage(
                    message = (profileData as UiState.Error).errorMessage,
                    onRetry = { viewModel.getProfileData() }
                )
            }
            is UiState.NotLogged -> {
                navigateToLogin()
            }
        }
    }
}

@Composable
fun ProfileContent(
    data: DetailData,
    onLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(R.drawable.people),
                contentDescription = "dummy logo",
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = data.firstname + " " + data.lastname,
            fontFamily = poppinsBold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Status",
                    fontFamily = poppinsBold,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = data.status.getStatus(),
                        fontFamily = poppins,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black,
                    )
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Billing Type",
                    fontFamily = poppinsBold,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = data.billingtype,
                        fontFamily = poppins,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                ProfileSection(title = "Email", desc = data.email)
                ProfileSection(title = "Mobile Phone", desc = data.mobilePhone)
                ProfileSection(title = "Company", desc = data.company)
                ProfileSection(title = "Address", desc = data.address1)
                ProfileSection(title = "Postal Code", desc = data.postalCode)
                Button(
                    onClick = onLogout,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text(
                        text = "Logout",
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.White,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
    title: String,
    desc: String
) {
    Column(
        modifier = modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = title,
            fontFamily = poppinsBold,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = desc,
            fontFamily = poppins,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

//@Preview
//@Composable
//fun ProfileScreenPreview() {
//    CloudRayaAppsTheme {
//        ProfileScreen()
//    }
//}