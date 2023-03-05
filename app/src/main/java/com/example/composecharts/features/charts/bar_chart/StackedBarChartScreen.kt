package com.example.composecharts.features.charts.bar_chart

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecharts.R
import com.example.composecharts.components.StackedBarChart
import com.example.composecharts.features.charts.ChartScreen
import com.example.composecharts.features.charts.stackedBarChartInputs

@Composable
internal fun StackedBarChartScreen() {

    ChartScreen(
        title = stringResource(id = R.string.label_stacked_bar_chart),
        chart = {
            StackedBarChart(
                modifier = Modifier.padding(20.dp),
                values = stackedBarChartInputs()
            )
        }
    )

}