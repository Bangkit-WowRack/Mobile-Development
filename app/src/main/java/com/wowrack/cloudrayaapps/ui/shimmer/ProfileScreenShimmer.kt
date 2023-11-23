package com.wowrack.cloudrayaapps.ui.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreenShimmering() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        ProfileShimmerItem(brush = brush)
    }

}

@Composable
fun ProfileShimmerItem(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .padding(16.dp)
                .size(100.dp)
                .clip(CircleShape)
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.2f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxWidth(fraction = 0.25f)
                        .background(brush)
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.2f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxWidth(fraction = 0.25f)
                        .background(brush)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.2f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.75f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.35f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.38f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.3f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.5f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.2f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 1f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.8f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.2f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.35f)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(fraction = 0.75f)
                            .background(brush)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileShimmerItemPreview() {
    ProfileShimmerItem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f),
            )
        )
    )
}