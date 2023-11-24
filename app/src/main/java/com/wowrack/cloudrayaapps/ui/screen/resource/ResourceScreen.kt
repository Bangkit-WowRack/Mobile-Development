package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.data.model.ServersItem
import com.wowrack.cloudrayaapps.data.model.VirtualMachineData
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ProjectList
import com.wowrack.cloudrayaapps.ui.shimmer.ResourceScreenShimmering
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun ResourceScreen(
    navigateToLogin: () -> Unit,
    navigateToMonitor: (String) -> Unit,
    navigateToServer: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ResourceViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val vmListData by viewModel.vmListData

    when (vmListData) {
        is UiState.Loading -> {
            ResourceScreenShimmering()
        }
        is UiState.Success -> {
            ResourceContent(
                data = (vmListData as UiState.Success).data.data?.servers,
                navigateToMonitor,
                navigateToServer,
            )
        }
        is UiState.Error -> {
            Text(text = "Error")
        }
        is UiState.NotLogged -> {
            navigateToLogin()
        }
    }
}

@Composable
fun ResourceContent(
    data: List<ServersItem>?,
    navigateToMonitor: (String) -> Unit,
    navigateToServer: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "VM List",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        if (data == null) {
            Text(text = "No Data")
        } else {
            data.forEach {
                ProjectList(
                    it,
//                    navigateToMonitor,
//                    navigateToServer,
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ResourceScreenPreview() {
//    CloudRayaAppsTheme {
//        ResourceScreen({}, {})
//    }
//}