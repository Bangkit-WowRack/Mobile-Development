package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.data.dummy.getDummyNotification
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@Composable
fun NotificationList() {
    val dummyNotification = getDummyNotification()

    LazyColumn(
        state = rememberLazyListState(),
    ) {
        items(dummyNotification.size) { index ->
            val notification = dummyNotification[index]
            Column {
                key(notification.id) {
                    NotificationItem(notification)
                    if (index < dummyNotification.size - 1) {
                        Divider() // Your Divider composable here
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationItem(
    notification: Notification,
    modifier: Modifier = Modifier,
) {
   Column(
       Modifier
           .fillMaxWidth()
           .background(color = Color(0x30009EFB))
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
           text = notification.date,
           fontFamily = poppins,
           fontSize = 12.sp,
           modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
           color = MaterialTheme.colorScheme.onBackground
       )
   }
}

@Composable
fun NotificationItemHome(
    notification: Notification,
    modifier: Modifier = Modifier,
) {
    Column(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(color = Color(0x30009EFB)),
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
            text = notification.date,
            fontFamily = poppins,
            fontSize = 10.sp,
            modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun NotificationListHome(
    data: List<Notification>,
    navigateToNotification: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        state = rememberLazyListState(),
    ) {
        items(data, key = { it.id }) { notification ->
            NotificationItemHome(notification)
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

//@Preview(showBackground = true)
//@Composable
//fun NotificationPreview() {
//    CloudRayaAppsTheme {
//        NotificationList()
//    }
//}