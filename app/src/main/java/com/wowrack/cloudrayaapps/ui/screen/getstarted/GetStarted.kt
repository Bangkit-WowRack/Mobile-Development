package com.wowrack.cloudrayaapps.ui.screen.getstarted

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wowrack.cloudrayaapps.ui.common.pages
import com.wowrack.cloudrayaapps.ui.components.OnboardingItem
import com.wowrack.cloudrayaapps.ui.components.PageIndicator
import com.wowrack.cloudrayaapps.ui.components.StartButton
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GetStartedScreen(
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(0) { pages.size }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState
            ) { index ->
                OnboardingItem(page = pages[index])
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        StartButton(
            pagerState = pagerState,
            onClick = navigateToLogin
        )

        PageIndicator(
            pagerState = pagerState,
            pageCount = pages.size,
            modifier = Modifier.padding(bottom = 24.dp) // Adjust bottom padding as needed
        )
    }
}

@Preview
@Composable
fun GetStartedScreenPreview() {
    CloudRayaAppsTheme {
        GetStartedScreen({})
    }
}