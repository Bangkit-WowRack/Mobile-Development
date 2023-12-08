package com.wowrack.cloudrayaapps.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round

@Composable
fun LineChart(
    data: List<Pair<Int, Double>> = emptyList(),
    modifier: Modifier = Modifier
) {
    val spacing = 100f
    val graphColor = MaterialTheme.colorScheme.primary
    val transparentGraphColor = remember { graphColor.copy(alpha = 0.5f) }
    val upperValue = remember { (100.0) }
    val lowerValue = remember { (0.0) }
    val density = LocalDensity.current

    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 10.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        if (data.size >= 24) {
            val spacePerHour = (size.width - spacing) / 24

            val startIndex = data.size - 24
            val endIndex = data.size
            for (i in startIndex until endIndex step 2) {
                val hour = data[i].first
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        hour.toString(),
                        spacing + (i - startIndex) * spacePerHour,
                        size.height,
                        textPaint
                    )
                }
            }

            val percentageStep = (upperValue - lowerValue) / 5f
            (0..5).forEach { i ->
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        round(lowerValue + percentageStep * i).toString(),
                        30f,
                        size.height - spacing - i * size.height / 5f,
                        textPaint
                    )
                }
            }

            val strokePath = Path().apply {
                val height = size.height
                data.indices.forEach { i ->
                    val info = data[i]
                    val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                    val x1 = spacing + i * spacePerHour
                    val y1 = height - spacing - (ratio * height).toFloat()

                    if (i == 0) { moveTo(x1, y1) }
                    lineTo(x1, y1)
                }
            }

            drawPath(
                path = strokePath,
                color = graphColor,
                style = Stroke(
                    width = 2.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            val fillPath = android.graphics.Path(strokePath.asAndroidPath()).asComposePath().apply {
                lineTo(size.width - spacePerHour, size.height - spacing)
                lineTo(spacing, size.height - spacing)
                close()
            }

            drawPath(
                path = fillPath,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        transparentGraphColor,
                        Color.Transparent
                    ),
                    endY = size.height - spacing
                )
            )
        } else {
            val spacePerHour = (size.width - spacing) / data.size

            (data.indices).forEach { i ->
                val hour = data[i].first
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        hour.toString(),
                        spacing + i * spacePerHour,
                        size.height,
                        textPaint
                    )
                }
            }

            val percentageStep = (upperValue - lowerValue) / 5f
            (0..5).forEach { i ->
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        round(lowerValue + percentageStep * i).toString(),
                        30f,
                        size.height - spacing - i * size.height / 5f,
                        textPaint
                    )
                }
            }

            val strokePath = Path().apply {
                val height = size.height
                data.indices.forEach { i ->
                    val info = data[i]
                    val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                    val x1 = spacing + i * spacePerHour
                    val y1 = height - spacing - (ratio * height).toFloat()

                    if (i == 0) { moveTo(x1, y1) }
                    lineTo(x1, y1)
                }
            }

            drawPath(
                path = strokePath,
                color = graphColor,
                style = Stroke(
                    width = 2.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            val fillPath = android.graphics.Path(strokePath.asAndroidPath()).asComposePath().apply {
                lineTo(size.width - spacePerHour, size.height - spacing)
                lineTo(spacing, size.height - spacing)
                close()
            }

            drawPath(
                path = fillPath,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        transparentGraphColor,
                        Color.Transparent
                    ),
                    endY = size.height - spacing
                )
            )
        }

    }
}