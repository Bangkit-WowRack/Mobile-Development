package com.wowrack.cloudrayaapps.ui.screen.monitor.undertab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.model.VMDetailData
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@Composable
fun DetailContent(
    data: VMDetailData,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier
//            .verticalScroll(state = scrollState)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        ) {
            Column(
                modifier.padding(16.dp)
            ) {
                Text(
                    text = "VM Information",
                    fontFamily = poppinsBold,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Divider(
                    modifier.width(140.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Project Tag",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.projectTag ?: "No Project Tag",
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Status",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.status,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Launch Date",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.launchDate,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        ) {
            Column(
                modifier.padding(16.dp)
            ) {
                Text(
                    text = "VM Detail",
                    fontFamily = poppinsBold,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Divider(
                    modifier.width(140.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Location",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.location,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Type Package",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.vmPackage,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "CPU",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "${data.cpu} Core",
                            fontFamily = poppinsBold,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Column {
                        Text(
                            text = "Memory",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "${data.memory} MB",
                            fontFamily = poppinsBold,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Column {
                        Text(
                            text = "Storage",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "${data.rootdiskSize} GB",
                            fontFamily = poppinsBold,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Operating System",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.os,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Main Public and Private IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Public IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.publicIp,
                    fontFamily = poppinsBold,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Private IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                    color = MaterialTheme.colorScheme.onBackground
                )
                data.privateIp.forEach {
                    Text(
                        text = it,
                        fontFamily = poppinsBold,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}