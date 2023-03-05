package com.example.composecharts.features.charts.gauge_chart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecharts.R
import com.example.composecharts.components.GaugeChart
import com.example.composecharts.features.charts.ChartScreen
import com.example.composecharts.features.charts.gaugePercent

@Composable
internal fun GaugeChartScreen() {

    ChartScreen(
        title = stringResource(id = R.string.label_gauge_chart),
        chart = {
            GaugeChart(
                modifier = Modifier.padding(20.dp),
                percentValue = gaugePercent,
                primaryColor = MaterialTheme.colors.onSecondary
            )
        }
    )

}