package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wowrack.cloudrayaapps.ui.theme.poppins

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartButton(
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(24.dp)
    ) {
        AnimatedVisibility(
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.LightGray,
                )
            ) {
                Text(
                    text = "Start",
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = poppins,
                )
            }
        }
    }
}