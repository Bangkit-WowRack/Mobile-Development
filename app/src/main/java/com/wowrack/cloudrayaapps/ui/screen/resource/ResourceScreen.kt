package com.wowrack.cloudrayaapps.ui.screen.resource

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.data.model.ServersItem
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.components.ProjectList
import com.wowrack.cloudrayaapps.ui.shimmer.ResourceScreenShimmering
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@Composable
fun ResourceScreen(
    navigateToLogin: () -> Unit,
    navigateToMonitor: (Int) -> Unit,
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
            )
        }
        is UiState.Error -> {
            ErrorMessage(
                message = (vmListData as UiState.Error).errorMessage,
                onRetry = { viewModel.getVMList() }
            )
        }
        is UiState.NotLogged -> {
            navigateToLogin()
        }
    }
}

@Composable
fun ResourceContent(
    data: List<ServersItem>?,
    navigateToMonitor: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "VM List",
            fontFamily = poppinsBold,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        if (data == null) {
            Text(text = "No Data")
        } else {
            data.forEach {
                ProjectList(
                    it,
                    navigateToMonitor,
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