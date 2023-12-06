package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.data.model.VMAction
import com.wowrack.cloudrayaapps.data.model.VMDetailData
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.CustomTab
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.DetailContent
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.UsageContent
import com.wowrack.cloudrayaapps.ui.shimmer.DetailCardShimmering
import com.wowrack.cloudrayaapps.ui.theme.poppins
import kotlinx.coroutines.Job

@Composable
fun MonitorScreen(
    id: Int,
    navigateToLogin: () -> Unit,
    navigateToServer: (Int) -> Unit,
    snackbar: (String) -> Job,
    modifier: Modifier = Modifier,
    viewModel: MonitorViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val vmDetail by viewModel.vmDetail

    DisposableEffect(key1 = id) {
        viewModel.getVMDetail(id)
        onDispose {

        }
    }

    when (vmDetail) {
        is UiState.Loading -> {
            DetailCardShimmering()
        }
        is UiState.Success -> {
            MonitorContent(
                data = (vmDetail as UiState.Success).data.data,
                navigateToServer = navigateToServer,
                viewModel = viewModel,
                snackbar = snackbar
            )
        }
        is UiState.Error -> {
            ErrorMessage(
                message = (vmDetail as UiState.Error).errorMessage,
                onRetry = { viewModel.getVMDetail(id) }
            )
        }
        is UiState.NotLogged -> {
            navigateToLogin()
        }
    }
}

@Composable
fun MonitorContent(
    data: VMDetailData,
    navigateToServer: (Int) -> Unit,
    viewModel: MonitorViewModel,
    snackbar: (String) -> Job,
    modifier: Modifier = Modifier
) {
    val vmActionStatus by viewModel.actionVMStatus

    var selected by remember { mutableIntStateOf(0) }

    DisposableEffect(key1 = vmActionStatus) {
        when (vmActionStatus) {
            is UiState.Loading -> {
                viewModel.getVMDetail(data.vpcId)
            }
            is UiState.Success -> {
                viewModel.getVMDetail(data.vpcId)
            }
            is UiState.Error -> {
                snackbar(((vmActionStatus as UiState.Error).errorMessage))
            }
            is UiState.NotLogged -> {
                // do nothing
            }
        }
        onDispose {

        }
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Column {
            Text(
                text = "Vm Detail",
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = data.hostname,
                fontFamily = poppins,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { viewModel.doVMAction(data.vpcId, VMAction.START) },
                    enabled = data.status == "Stopped",
                    modifier = modifier.size(53.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        containerColor = Color(0xFF34D399)
                    )
                ) {
                    Icon(Icons.Filled.PlayArrow,
                        contentDescription = "Start",
                        modifier = Modifier
                        .size(37.dp)
                    )
                }
                IconButton(
                    onClick = { viewModel.doVMAction(data.vpcId, VMAction.STOP) },
                    enabled = data.status == "Running",
                    modifier = modifier.size(53.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        containerColor = Color(0xFFEF4444)
                    )
                ) {
                    Icon(
                        Icons.Filled.Stop,
                        contentDescription = "Stop",
                        modifier = Modifier
                            .size(37.dp)
                    )
                }
                IconButton(
                    onClick = { viewModel.doVMAction(data.vpcId, VMAction.REBOOT) },
                    enabled = data.status == "Stopped" || data.status == "Running",
                    modifier = modifier.size(53.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        containerColor = Color(0xFFFFC107)
                    )
                ) {
                    Icon(
                        Icons.Filled.Refresh,
                        contentDescription = "Reboot",
                        modifier = Modifier
                            .size(37.dp)
                    )
                }
                IconButton(
                    onClick = { navigateToServer(data.vpcId) },
                    enabled = data.status == "Running",
                    modifier = modifier.size(53.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        containerColor = Color(0xFF06B6D4)
                    )
                ) {
                    Icon(
                        Icons.Filled.Monitor,
                        contentDescription = "SSH",
                        modifier = Modifier
                            .size(37.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomTab(
                modifier = Modifier.fillMaxWidth(),
                selectedItemIndex = selected,
                items = listOf("Detail", "Usage"),
                onClick = { selected = it }
            )

            when (selected) {
                0 -> DetailContent(
                    data = data,
                )
                1 -> UsageContent()
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight())
    }
}


//@Preview
//@Composable
//fun MonitorScreenPreview() {
//    CloudRayaAppsTheme {
//        Surface {
//            MonitorContent()
//        }
//    }
//}