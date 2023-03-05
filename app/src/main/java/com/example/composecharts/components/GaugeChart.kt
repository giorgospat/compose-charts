package com.example.composecharts.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.min

private const val animationDuration = 800

@Composable
internal fun GaugeChart(
    modifier: Modifier = Modifier,
    percentValue: Int,
    primaryColor: Color,
    animated: Boolean = true
) {

    assert(percentValue in 0..100) { "percent must be between 0 - 100" }

    // animate indicator position on composition
    val progress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(percentValue) {
        progress.animateTo(
            targetValue = percentValue.toFloat(),
            animationSpec = tween(if (animated) animationDuration else 0)
        )
    }

    val density = LocalDensity.current
    val needleBaseSize = with(density) { 1.dp.toPx() }
    val strokeWidth = with(density) { 6.dp.toPx() }
    val textFontSize = with(density) { 16.dp.toPx() }
    val fontPadding = with(density) { 5.dp.toPx() }

    val gaugeDegrees = 180
    val startAngle = 180f

    val needlePaint = remember { Paint().apply { color = primaryColor } }
    val textPaint = remember {
        android.graphics.Paint().apply {
            color = primaryColor.toArgb()
            textSize = textFontSize
            textAlign = android.graphics.Paint.Align.CENTER
        }
    }

    // brush with color stops, where each color can have custom proportion
    val brush = Brush.horizontalGradient(
        0.1f to MaterialTheme.colors.secondary,
        0.2f to MaterialTheme.colors.primaryVariant,
        0.5f to MaterialTheme.colors.primary,
    )

    BoxWithConstraints(modifier = modifier, contentAlignment = Alignment.Center) {

        val canvasSize = min(constraints.maxWidth, constraints.maxHeight)
        val size = Size(canvasSize.toFloat(), canvasSize.toFloat())
        val canvasSizeDp = with(density) { canvasSize.toDp() }
        val w = size.width
        val h = size.height
        val center = Offset(w / 2, h / 2)
        val textY = center.y + textFontSize + fontPadding

        Canvas(
            modifier = Modifier.size(canvasSizeDp),
            onDraw = {

                /** Gauge implementation */

                drawArc(
                    brush = brush,
                    startAngle = startAngle,
                    sweepAngle = gaugeDegrees.toFloat(),
                    useCenter = false,
                    size = size,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )

                drawIntoCanvas { canvas ->

                    /** Needle implementation */

                    canvas.save()

                    // rotate canvas based on progress, to move the needle
                    canvas.rotate(
                        degrees = progress.value.percentToAngle(max = gaugeDegrees),
                        pivotX = center.x,
                        pivotY = center.y
                    )

                    //draw Needle shape
                    canvas.drawPath(
                        Path().apply {
                            moveTo(center.x, center.x)
                            lineTo(center.x, center.y + needleBaseSize)
                            lineTo(w / 6, center.y)
                            lineTo(center.x, center.y - 5)
                            close()
                        },
                        needlePaint
                    )

                    canvas.restore()

                    /** Text bellow needle */

                    // draw percentage text
                    canvas.nativeCanvas.drawText(
                        percentValue.toString(),
                        center.x,
                        textY,
                        textPaint
                    )

                }
            }
        )
    }

}

private fun Float.percentToAngle(max: Int): Float {
    return (this * max / 100)
}