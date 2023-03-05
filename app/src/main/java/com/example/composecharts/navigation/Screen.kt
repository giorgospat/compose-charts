package com.example.composecharts.navigation

internal enum class Screen(val path: String) {
    Home("home"),
    PieChart("pieChart"),
    DonutChart("donutChart"),
    GaugeChart("gaugeChart"),
    BarChart("barChart"),
    StackedBarChart("stackedBarChart")
}

internal fun Screen.toRoute(): String {
    return "/${this.path}"
}