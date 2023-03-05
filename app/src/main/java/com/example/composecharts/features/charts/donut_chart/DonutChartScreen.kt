package com.example.composecharts.features.charts.donut_chart

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.composecharts.R
import com.example.composecharts.components.DonutChart
import com.example.composecharts.features.charts.ChartScreen
import com.example.composecharts.features.charts.chartColors
import com.example.composecharts.features.charts.chartValues

@Composable
internal fun DonutChartScreen() {

    ChartScreen(
        title = stringResource(id = R.string.label_donut_chart),
        chart = {
            DonutChart(
                colors = chartColors(),
                inputValues = chartValues,
                textColor = MaterialTheme.colors.primary
            )
        }
    )

}