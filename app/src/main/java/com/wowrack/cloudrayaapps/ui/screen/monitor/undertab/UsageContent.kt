package com.wowrack.cloudrayaapps.ui.screen.monitor.undertab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.ui.components.LineChart
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun CPUTab(modifier: Modifier = Modifier) {
    Column {
        val data = listOf(
            Pair(1, 0.0),
            Pair(2, 34.45),
            Pair(3, 21.35),
            Pair(4, 40.25),
            Pair(5, 34.45),
            Pair(6, 51.35),
            Pair(7, 40.25),
            Pair(8, 64.45),
            Pair(9, 51.35),
            Pair(10, 70.25),
            Pair(11, 64.45),
            Pair(12, 81.35),
            Pair(13, 70.25),
            Pair(14, 94.45),
            Pair(15, 81.35),
            Pair(16, 61.35),
            Pair(17, 70.25),
            Pair(18, 54.45),
            Pair(19, 61.35),
            Pair(20, 41.35),
            Pair(21, 50.25),
            Pair(22, 34.45),
            Pair(23, 41.35),
            Pair(23, 0.0),
        )

        Spacer(modifier = Modifier.height(32.dp))
        LineChart(
            data = data,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun MemoryTab(modifier: Modifier = Modifier) {
    Column {
        val data = listOf(
            Pair(1, 10.25),
            Pair(2, 34.45),
            Pair(3, 21.35),
            Pair(4, 40.25),
            Pair(5, 34.45),
            Pair(6, 51.35),
            Pair(7, 40.25),
            Pair(8, 64.45),
            Pair(9, 51.35),
            Pair(10, 70.25),
            Pair(11, 64.45),
            Pair(12, 81.35),
            Pair(13, 70.25),
            Pair(14, 94.45),
            Pair(15, 81.35),
            Pair(16, 61.35),
            Pair(17, 70.25),
            Pair(18, 54.45),
            Pair(19, 61.35),
            Pair(20, 41.35),
            Pair(21, 50.25),
            Pair(22, 94.45),
            Pair(23, 41.35),
            Pair(23, 21.35),
        )

        Spacer(modifier = Modifier.height(32.dp))
        LineChart(
            data = data,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun BandwidthTab(modifier: Modifier = Modifier) {
    Column {
        val data = listOf(
            Pair(1, 10.25),
            Pair(2, 34.45),
            Pair(3, 21.35),
            Pair(4, 40.25),
            Pair(5, 34.45),
            Pair(6, 51.35),
            Pair(7, 40.25),
            Pair(8, 14.45),
            Pair(9, 51.35),
            Pair(10, 70.25),
            Pair(11, 64.45),
            Pair(12, 81.35),
            Pair(13, 70.25),
            Pair(14, 94.45),
            Pair(15, 81.35),
            Pair(16, 61.35),
            Pair(17, 70.25),
            Pair(18, 54.45),
            Pair(19, 61.35),
            Pair(20, 41.35),
            Pair(21, 50.25),
            Pair(22, 34.45),
            Pair(23, 41.35),
            Pair(23, 21.35),
        )

        Spacer(modifier = Modifier.height(32.dp))
        LineChart(
            data = data,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}