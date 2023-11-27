package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.CustomTab
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.DetailContent
import com.wowrack.cloudrayaapps.ui.screen.monitor.undertab.UsageContent
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun MonitorScreen(
    id: String,
    modifier: Modifier = Modifier,
    viewModel: MonitorViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        MonitorContent()
//        DetailContent()
//    }
    MonitorContent()
}

@Composable
fun MonitorContent(
    modifier: Modifier = Modifier
) {
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
                text = "VM Name",
                fontFamily = poppins,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val (selected, setSelected) = remember {
                mutableStateOf(0)
            }

            CustomTab(
                modifier = Modifier.fillMaxWidth(),
                selectedItemIndex = selected,
                items = listOf("Detail", "Usage"),
                onClick = { index -> setSelected(index) }
            )

            when (selected) {
                0 -> DetailContent()
                1 -> UsageContent()
            }
        }
    }
}


@Preview
@Composable
fun MonitorScreenPreview() {
    CloudRayaAppsTheme {
        Surface {
            MonitorScreen("1")
        }
    }
}