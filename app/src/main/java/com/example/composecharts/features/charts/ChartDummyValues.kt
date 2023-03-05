package com.example.composecharts.features.charts

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.example.composecharts.extensions.toPercent
import com.example.composecharts.features.charts.bar_chart.StackedData

@Composable
@ReadOnlyComposable
internal fun chartColors(): List<Color> {
    return listOf(
        MaterialTheme.colors.primary,
        MaterialTheme.colors.primaryVariant,
        MaterialTheme.colors.secondary
    )
}

internal val chartValues = listOf(
    60f,
    110f,
    20f
)

internal val barChartInputsPercent = (0..10).map { (1..100).random().toFloat() }

@Composable
@ReadOnlyComposable
internal fun stackedBarChartInputs() = (0..5).map {
    val inputs = (0..2).map { (1..100).random().toFloat() }.toPercent()
    StackedData(
        inputs = inputs,
        colors = listOf(
            MaterialTheme.colors.primary,
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.secondary
        )
    )
}

internal const val gaugePercent = 70