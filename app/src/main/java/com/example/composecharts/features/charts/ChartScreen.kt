package com.example.composecharts.features.charts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecharts.components.Toolbar

@Composable
internal fun ChartScreen(
    title: String,
    chart: @Composable () -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Toolbar(title = title)

        Spacer(modifier = Modifier.height(20.dp))

        chart()

    }

}