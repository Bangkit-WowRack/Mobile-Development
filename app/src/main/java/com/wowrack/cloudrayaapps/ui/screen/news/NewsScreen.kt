package com.wowrack.cloudrayaapps.ui.screen.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins
import com.wowrack.cloudrayaapps.ui.theme.poppinsBold

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier
            .verticalScroll(state = scrollState)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        NewsContent()
    }
}

@Composable
fun NewsContent() {
    Column {
        Text(
            text = "News",
            fontFamily = poppinsBold,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Promo KETUPAT! Get IDR 250K for First Top Up",
            fontFamily = poppinsBold,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text  =  "We would like to inform you about a price adjustment for our 'Managed Service.' Starting September 1st, 2023, there will be adjustments to the pricing as follows:\n\n1. New Price: IDR 750K per hour (formerly IDR 650K per hour)\n2. Bundle of 3 hours: IDR 1950K (formerly IDR 1650K)\n\nWe are making this adjustment to ensure we continuously provide you with the best experience from our team of expert support professionals. Additionally, due to the rapid growth of our customer base, we have expanded our support team to ensure prompt responses and timely solutions for all your requests and needs.\n\nIf you wish to take advantage of the bundle offer at the current price, you still have the opportunity to do so before the effective date of the price adjustment.\n\nShould there be any questions or if you require assistance related to our services, please feel free to reach out to our support team at support@wowrack.co.id.\n\nThank you for your understanding and continued support. We remain dedicated to providing you with exceptional solutions and services for your business.\n\nWarm regards, Cloud Raya Team",
            fontFamily = poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun NewsPreview() {
    CloudRayaAppsTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            NewsScreen()
        }

    }
}