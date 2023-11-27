package com.wowrack.cloudrayaapps.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
private fun TabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(width = indicatorWidth)
            .offset(x = indicatorOffset)
            .clip(
                shape = CircleShape
            )
            .background(
                color = indicatorColor
            )
    )
}

@Composable
private fun TabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            Color.White
        } else {
            Color.Black
        },
        animationSpec = tween(easing = LinearEasing),
    )
    Text(
        modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 8.dp,
            ),
        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp? = null,
    onClick: (index: Int) -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val calculatedTabWidth = tabWidth ?: (screenWidth / items.size)

    val indicatorOffset: Dp by animateDpAsState(
        targetValue = calculatedTabWidth  * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing),
    )

    Column {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(Color.LightGray)
                .height(intrinsicSize = IntrinsicSize.Min),
        ) {
            TabIndicator(
                indicatorWidth = calculatedTabWidth,
                indicatorOffset = indicatorOffset,
                indicatorColor = MaterialTheme.colorScheme.primary
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.clip(CircleShape),
            ) {
                items.mapIndexed { index, text ->
                    val isSelected = index == selectedItemIndex
                    TabItem(
                        isSelected = isSelected,
                        onClick = {
                            onClick(index)
                        },
                        tabWidth = calculatedTabWidth,
                        text = text
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }


}