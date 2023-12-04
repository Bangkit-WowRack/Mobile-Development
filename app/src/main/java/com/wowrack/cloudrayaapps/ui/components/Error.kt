package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@Composable
fun Error(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Error Please Retry",
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = modifier
                .width(120.dp)
                .height(IntrinsicSize.Min)
        ) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
fun ErrorPreview() {
    CloudRayaAppsTheme {
        Error()
    }
}