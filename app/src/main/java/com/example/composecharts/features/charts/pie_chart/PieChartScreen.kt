package com.example.composecharts.features.charts.pie_chart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecharts.R
import com.example.composecharts.components.PieChart
import com.example.composecharts.features.charts.ChartScreen
import com.example.composecharts.features.charts.chartColors
import com.example.composecharts.features.charts.chartValues


@Composable
internal fun PieChartScreen() {

    ChartScreen(
        title = stringResource(id = R.string.label_pie_chart),
        chart = {
            PieChart(
                modifier = Modifier.padding(20.dp),
                colors = chartColors(),
                inputValues = chartValues,
                textColor = MaterialTheme.colors.secondaryVariant
            )
        }
    )

}