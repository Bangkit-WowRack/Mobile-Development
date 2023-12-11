package com.wowrack.cloudrayaapps.ui.screen.monitor.undertab

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.model.BandwidthResponse
import com.wowrack.cloudrayaapps.data.model.UsageResponse
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.components.LineChart
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold
import com.wowrack.cloudrayaapps.utils.getBandwidthUsage
import com.wowrack.cloudrayaapps.utils.getCPUUsage
import com.wowrack.cloudrayaapps.utils.getMemoryUsage

@Composable
fun CPUTab(
    data: UiState<UsageResponse>,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        when (data) {
            is UiState.Success -> {
                val chartData = data.data.data

                if (chartData.isEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .shadow(4.dp, RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                        ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "No Data",
                                fontFamily = poppinsBold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                    LineChart(
                        data = chartData.getCPUUsage(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }

            is UiState.Error -> {
                ErrorMessage(
                    message = data.errorMessage,
                    onRetry = onRetry
                )
            }

            is UiState.Loading -> {
                // do nothing
            }

            else -> {
                // do nothing
            }
        }
    }
}

@Composable
fun MemoryTab(
    data: UiState<UsageResponse>,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        when (data) {
            is UiState.Success -> {
                val chartData = data.data.data

                if (chartData.isEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .shadow(4.dp, RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                        ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No Data",
                                fontFamily = poppinsBold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                    LineChart(
                        data = chartData.getMemoryUsage(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }

            is UiState.Error -> {
                ErrorMessage(
                    message = data.errorMessage,
                    onRetry = onRetry
                )
            }

            is UiState.Loading -> {
                // do nothing
            }

            else -> {
                // do nothing
            }
        }
    }
}

@Composable
fun BandwidthTab(
    data: UiState<BandwidthResponse>,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        when (data) {
            is UiState.Success -> {
                val chartData = data.data.data

                if (chartData.isEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .shadow(4.dp, RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                        ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No Data",
                                fontFamily = poppinsBold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.height(32.dp))
                    LineChart(
                        data = chartData.getBandwidthUsage(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }


            is UiState.Error -> {
                ErrorMessage(
                    message = data.errorMessage,
                    onRetry = onRetry
                )
            }

            is UiState.Loading -> {
                // do nothing
            }

            else -> {
                // do nothing
            }
        }
    }
}