package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.utils.truncateText

@Composable
fun NotificationList(
    modifier: Modifier = Modifier,
) {

    val dummyNotification = listOf(
        Notification(
            id = 1,
            logo = "https://picsum.photos/200/200",
            title = "Test 1",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 2,
            logo = "https://picsum.photos/200/200",
            title = "Test 2",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 3,
            logo = "https://picsum.photos/200/200",
            title = "Test 3",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 4,
            logo = "https://picsum.photos/200/200",
            title = "Test 4",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 5,
            logo = "https://picsum.photos/200/200",
            title = "Test 5",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 6,
            logo = "https://picsum.photos/200/200",
            title = "Test 6",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 7,
            logo = "https://picsum.photos/200/200",
            title = "Test 7",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 8,
            logo = "https://picsum.photos/200/200",
            title = "Test 8",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 9,
            logo = "https://picsum.photos/200/200",
            title = "Test 9",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 10,
            logo = "https://picsum.photos/200/200",
            title = "Test 10",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 11,
            logo = "https://picsum.photos/200/200",
            title = "Test 11",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
        Notification(
            id = 12,
            logo = "https://picsum.photos/200/200",
            title = "Test 12",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            date =  "2021-09-01",
        ),
    )

    LazyColumn(
//        state = listState,
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        items(dummyNotification, key = { it.id }) { notification ->
            NotificationItem(notification)
        }
    }
}

@Composable
fun NotificationItem(
    notification: Notification,
    modifier: Modifier = Modifier,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = notification.logo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column {
            Text(notification.title, fontFamily = poppins,)
            Text(notification.description.truncateText(), fontFamily = poppins,)
        }
    }

//
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier.clickable {}
//    ) {
//        AsyncImage(
//            model = notification.logo,
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .padding(8.dp)
//                .size(60.dp)
//                .clip(CircleShape)
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(
//                text = notification.title,
//                fontWeight = FontWeight.Medium,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .padding(start = 16.dp)
//            )
//            Text(
//                text = notification.title,
//                fontWeight = FontWeight.Medium,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .padding(start = 16.dp)
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun NotificationPreview() {
    CloudRayaAppsTheme {
        NotificationList()
    }
}