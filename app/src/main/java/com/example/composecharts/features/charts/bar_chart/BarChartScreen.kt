package com.example.composecharts.features.charts.bar_chart

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecharts.R
import com.example.composecharts.components.BarChart
import com.example.composecharts.features.charts.ChartScreen
import com.example.composecharts.features.charts.barChartInputsPercent

@Composable
internal fun BarChartScreen() {

    ChartScreen(
        title = stringResource(id = R.string.label_bar_chart),
        chart = {
            BarChart(
                modifier = Modifier.padding(20.dp),
                values = barChartInputsPercent
            )
        }
    )

}