package com.wowrack.cloudrayaapps.ui.screen.monitor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Preview(showBackground = true)
@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
) {
    Column() {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            Column(
                modifier.padding(16.dp)
            ) {
                Text(
                    text = "VM Information",
                    fontFamily = poppins,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Divider(
                    modifier.width(140.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Hostname",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "VMSeattle12345",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Status",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "Active - Running",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Launch Date",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "2023-11-21 20:39:14",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
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
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            Column(
                modifier.padding(16.dp)
            ) {
                Text(
                    text = "VM Detail",
                    fontFamily = poppins,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Divider(
                    modifier.width(140.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Location",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "Jakarta",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Type Package",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "Ax-small",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
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
                            modifier = modifier,
                        )
                        Text(
                            text = "1 Core",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                        )
                    }
                    Column {
                        Text(
                            text = "Memory",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            modifier = modifier,
                        )
                        Text(
                            text = "1024 MB",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                        )
                    }
                    Column {
                        Text(
                            text = "Storage",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            modifier = modifier,
                        )
                        Text(
                            text = "20 GB",
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Operating System",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "Ubuntu 20.04 with cPanel",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Main Public and Private IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Public IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "163.53.192.66",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
                Text(
                    text = "Private IP",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    modifier = modifier,
                )
                Text(
                    text = "10.10.19.175",
                    fontFamily = poppins,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier,
                )
            }
        }
    }
}