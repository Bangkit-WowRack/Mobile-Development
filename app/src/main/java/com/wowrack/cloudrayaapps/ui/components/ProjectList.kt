package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.R
import com.wowrack.cloudrayaapps.data.model.ServersItem
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold


@Composable
fun ProjectList(
    data: ServersItem,
    navigateToMonitor: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .clickable {
                navigateToMonitor(data.localId)
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cube_solid),
                contentDescription = null,
                modifier = Modifier
                    .padding(12.dp)
                    .size(40.dp)
            )
            Column {
                Text(
                    text = data.name,
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = data.status,
                    fontFamily = poppinsBold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
//            Spacer(modifier = Modifier.weight(1f))
//            ThreeDotMenu()
        }
    }
}

//@Composable
//fun ThreeDotMenu() {
//    var expanded by remember { mutableStateOf(false) }
//
//    Box(
//        contentAlignment = Alignment.TopEnd
//    ) {
//        IconButton(onClick = { expanded = true }) {
//            Icon(Icons.Filled.MoreVert, contentDescription = "Menu")
//        }
//
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier
//                .padding(end = 8.dp)
//                .widthIn(max = 120.dp)
//                .background(Color.White),
//        ) {
//            DropdownMenuItem(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp),
//                text = { Text(text = "Monitor") },
//                onClick = {
//                    expanded = false
//                }
//            )
//            DropdownMenuItem(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp),
//                text = { Text(text = "Security") },
//                onClick = {
//                    expanded = false
//                }
//            )
//        }
//    }
//}