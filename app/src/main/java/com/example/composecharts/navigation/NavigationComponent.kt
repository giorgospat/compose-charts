package com.example.composecharts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecharts.features.home.HomeScreen
import com.example.composecharts.features.charts.donut_chart.DonutChartScreen
import com.example.composecharts.features.charts.gauge_chart.GaugeChartScreen
import com.example.composecharts.features.charts.pie_chart.PieChartScreen
import com.example.composecharts.features.charts.bar_chart.BarChartScreen
import com.example.composecharts.features.charts.bar_chart.StackedBarChartScreen

@Composable
fun NavigationComponent(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.toRoute()
    ) {
        composable(Screen.Home.toRoute()) {
            HomeScreen { screen ->
                navController.navigate(screen.toRoute())
            }
        }
        composable(Screen.PieChart.toRoute()) {
            PieChartScreen()
        }
        composable(Screen.DonutChart.toRoute()) {
            DonutChartScreen()
        }
        composable(Screen.GaugeChart.toRoute()) {
            GaugeChartScreen()
        }
        composable(Screen.BarChart.toRoute()) {
            BarChartScreen()
        }
        composable(Screen.StackedBarChart.toRoute()) {
            StackedBarChartScreen()
        }
    }

}