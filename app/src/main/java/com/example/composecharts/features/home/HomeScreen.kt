package com.example.composecharts.features.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecharts.R
import com.example.composecharts.navigation.Screen

@Composable
internal fun HomeScreen(onClick: (Screen) -> Unit) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        MenuButton(textId = R.string.label_pie_chart, onClick = { onClick(Screen.PieChart) })
        MenuButton(textId = R.string.label_donut_chart, onClick = { onClick(Screen.DonutChart) })
        MenuButton(textId = R.string.label_gauge_chart, onClick = { onClick(Screen.GaugeChart) })
        MenuButton(textId = R.string.label_bar_chart, onClick = { onClick(Screen.BarChart) })
        MenuButton(textId = R.string.label_stacked_bar_chart, onClick = { onClick(Screen.StackedBarChart) })

    }

}

@Composable
private fun MenuButton(@StringRes textId: Int, onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(text = stringResource(textId))
    }
}