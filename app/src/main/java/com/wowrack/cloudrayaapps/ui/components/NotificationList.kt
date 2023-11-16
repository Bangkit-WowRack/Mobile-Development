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
import com.wowrack.cloudrayaapps.data.dummy.getDummyNotification
import com.wowrack.cloudrayaapps.data.model.Notification
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.utils.truncateText

@Composable
fun NotificationList(
    modifier: Modifier = Modifier,
) {
    val dummyNotification = getDummyNotification()

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