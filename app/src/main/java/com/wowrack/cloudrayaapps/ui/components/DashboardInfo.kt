package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.data.model.DashboardData

@Composable
fun DashboardInfo(
    data: DashboardData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            CardDashboardItem(
                icon = R.drawable.ic_server_solid,
                title = "Total VMs",
                value = data.totalVm.toString(),
                info = "VMs"
            )
            Spacer(modifier = modifier.width(8.dp))
            CardDashboardItem(
                icon = R.drawable.ic_map_pin_solid,
                title = "Total Disk",
                value = "${data.totalDisk} GB",
                info = "Disk"
            )
        }
        Spacer(modifier = modifier.height(8.dp))
        Row {
            CardDashboardItem(
                icon = R.drawable.ic_check_circle_solid,
                title = "Total CPU",
                value = "${data.totalCpu} Cores",
                info = "CPU"
            )
            Spacer(modifier = modifier.width(8.dp))
            CardDashboardItem(
                icon = R.drawable.ic_times_circle_solid,
                title = "Total RAM",
                value = "${data.totalRam} GB",
                info = "RAM"
            )
        }
    }
}