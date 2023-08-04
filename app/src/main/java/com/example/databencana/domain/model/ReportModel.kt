package com.example.databencana.domain.model

import com.example.databencana.data.remote.response.ReportData

data class ReportModel(
    val type: String,
    val date: String,
    val source: String,
    val status: String,
    val url: String,
    val img: String,
    val report: ReportData,
    val title: String,
    val text: String,
    val coordinates: List<Double>


)
