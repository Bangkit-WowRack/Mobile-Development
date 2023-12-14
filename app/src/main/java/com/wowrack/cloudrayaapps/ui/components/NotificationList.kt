package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.data.model.NotificationItem
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold
import com.wowrack.cloudrayaapps.utils.formatUnixEpochTime

@Composable
fun NotificationList(
    data: List<NotificationItem>,
    navigateToMonitor: (Int) -> Unit,
) {
    LazyColumn(
        state = rememberLazyListState(),
    ) {
        if (data.isEmpty()) {
            item {
                Text(
                    text = "No Notification",
                    fontFamily = poppinsBold,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            items(data, key = { it.id }) { notification ->
                NotificationItem(
                    notification = notification,
                    navigateToMonitor = navigateToMonitor
                )
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}

@Composable
fun NotificationItem(
    notification: NotificationItem,
    navigateToMonitor: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
   Column(
       Modifier
           .fillMaxWidth()
           .background(color = Color(0x30009EFB))
           .clickable {
                navigateToMonitor(notification.vmId)
           }
   ){
       Text(
           text = notification.title,
           fontFamily = poppinsBold,
           fontSize = 16.sp,
           fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp),
           color = MaterialTheme.colorScheme.onBackground
       )
       Text(
           text = notification.description,
           fontFamily = poppins,
           fontSize = 12.sp,
           fontWeight = FontWeight.Bold,
           modifier = Modifier.padding(horizontal = 16.dp),
           color = MaterialTheme.colorScheme.onBackground
       )
       Text(
           text = notification.timestamp.formatUnixEpochTime(),
           fontFamily = poppins,
           fontSize = 12.sp,
           modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
           color = MaterialTheme.colorScheme.onBackground
       )
   }
}

@Composable
fun NotificationItemHome(
    notification: NotificationItem,
    navigateToMonitor: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(color = Color(0x30009EFB))
            .clickable {
                navigateToMonitor(notification.vmId)
            },
    ){
        Text(
            text = notification.title,
            fontFamily = poppinsBold,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = notification.description,
            fontFamily = poppins,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = notification.timestamp.formatUnixEpochTime(),
            fontFamily = poppins,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun NotificationListHome(
    data: List<NotificationItem>,
    navigateToNotification: () -> Unit,
    navigateToMonitor: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        state = rememberLazyListState(),
    ) {
        if (data.isEmpty()) {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "No Notification",
                        fontFamily = poppinsBold,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        } else {
            items(data, key = { it.id }) { notification ->
                NotificationItemHome(
                    notification = notification,
                    navigateToMonitor = navigateToMonitor
                )
                Spacer(modifier = Modifier.height(2.dp))
            }

            item {
                TextButton(
                    onClick = navigateToNotification,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Show More",
                        fontFamily = poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun NotificationPreview() {
//    CloudRayaAppsTheme {
//        NotificationList()
//    }
//}