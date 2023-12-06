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
import com.wowrack.cloudrayaapps.data.model.VMDetailData
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.CustomTab
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.DetailContent
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.UsageContent
import com.wowrack.cloudrayaapps.ui.shimmer.DetailCardShimmering
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun MonitorScreen(
    id: Int,
    navigateToLogin: () -> Unit,
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
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableIntStateOf(0) }

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
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier.size(56.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Green
                    )

                ) {
                    Icon(Icons.Filled.PlayArrow,
                        contentDescription = "Start",
                        modifier = Modifier
                        .size(40.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier.size(56.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Red
                    )

                ) {
                    Icon(
                        Icons.Filled.Stop,
                        contentDescription = "Stop",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier.size(56.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Yellow
                    )

                ) {
                    Icon(
                        Icons.Filled.Refresh,
                        contentDescription = "Reboot",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier.size(56.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color.Blue
                    )

                ) {
                    Icon(
                        Icons.Filled.Monitor,
                        contentDescription = "SSH",
                        modifier = Modifier
                            .size(40.dp)
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