package com.wowrack.cloudrayaapps.ui.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailCardShimmering() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition(label = "detailCard")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "detailCard"
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    DetailCardShimmerItem(brush = brush)
}

@Composable
fun DetailCardShimmerItem(brush: Brush) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(30.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.4f)
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Spacer(
            modifier = Modifier
                .height(25.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.2f)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(brush)
            )
            Spacer(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(brush)
            )
            Spacer(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(brush)
            )
            Spacer(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(brush)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Spacer(
            modifier = Modifier
                .height(40.dp)
                .clip(CircleShape)
                .fillMaxWidth(fraction = 1f)
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 1f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(fraction = 1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.5f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.3f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(16.dp))
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
                        .fillMaxWidth(fraction = 0.2f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.6f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.4f)
                        .background(brush)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 1f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(fraction = 1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.5f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.3f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(fraction = 1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.4f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.3f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                        Spacer(modifier = Modifier.padding(3.dp))
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                    }
                    Column {
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                        Spacer(modifier = Modifier.padding(3.dp))
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                    }
                    Column {
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                        Spacer(modifier = Modifier.padding(3.dp))
                        Spacer(
                            modifier = Modifier
                                .height(18.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.15f)
                                .background(brush)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(fraction = 1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.45f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.6f)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(fraction = 1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.6f)
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
                        .fillMaxWidth(fraction = 0.43f)
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
                        .fillMaxWidth(fraction = 0.4f)
                        .background(brush)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailCardShimmerItemPreview() {
    DetailCardShimmerItem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f),
            )
        )
    )
}