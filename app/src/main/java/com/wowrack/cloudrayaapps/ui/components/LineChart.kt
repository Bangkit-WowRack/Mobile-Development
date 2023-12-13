package com.wowrack.cloudrayaapps.ui.components

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun LineChart(
    data: List<Pair<Int, Double>> = emptyList(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val spacing = 100f
    val graphColor = MaterialTheme.colorScheme.primary
    val graphColorB = MaterialTheme.colorScheme.primary.toArgb()
    val backColor = MaterialTheme.colorScheme.onBackground
    val textColor = MaterialTheme.colorScheme.onBackground.toArgb()
    val upperValue = remember { (data.maxOfOrNull { it.second }?.plus(1))?.roundToInt() ?: 0 }
    val lowerValue = remember { (data.minOfOrNull { it.second }?.toInt() ?: 0) }
    val density = LocalDensity.current

    val textPaint = remember(density) {
        Paint().apply {
            color = textColor
            textAlign = Paint.Align.CENTER
            textSize = density.run { 10.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        if (data.size > 24) {
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

            val backPath = Path().apply {
                val height = size.height
                val width = size.width

                (0..5).forEach { i ->
                    val y = height - spacing - i * height / 5f
                    // Start line from the right edge (width) instead of (width - spacing)
                    moveTo(width, y)
                    // Draw line to the left edge (0)
                    lineTo(spacing, y)
                }
            }

            drawPath(
                path = backPath,
                color = backColor,
                style = Stroke(
                    width = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

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

            val circleRadius = 15f

            data.indices.forEach { i ->
                val info = data[i]
                val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                val x = spacing + i * spacePerHour
                val y = size.height - spacing - (ratio * size.height).toFloat()

                drawContext.canvas.nativeCanvas.drawCircle(
                    x,
                    y,
                    circleRadius,
                    Paint().apply {
                        color = graphColorB
                        style = Paint.Style.FILL
                    }
                )
            }

        } else {
            val spacePerHour = (size.width - spacing) / data.size

            (data.indices step 2).forEach { i ->
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


            val backPath = Path().apply {
                val height = size.height
                val width = size.width

                (0..5).forEach { i ->
                    val y = height - spacing - i * height / 5f
                    // Start line from the right edge (width) instead of (width - spacing)
                    moveTo(width, y)
                    // Draw line to the left edge (0)
                    lineTo(spacing, y)
                }
            }

            drawPath(
                path = backPath,
                color = backColor,
                style = Stroke(
                    width = 3.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

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
                    width = 4.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            val circleRadius = 15f

            data.indices.forEach { i ->
                val info = data[i]
                val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                val x = spacing + i * spacePerHour
                val y = size.height - spacing - (ratio * size.height).toFloat()

                drawContext.canvas.nativeCanvas.drawCircle(
                    x,
                    y,
                    circleRadius,
                    Paint().apply {
                        color = graphColorB
                        style = Paint.Style.FILL
                    }
                )
            }
        }

    }
}