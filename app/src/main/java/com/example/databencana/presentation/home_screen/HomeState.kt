package com.example.databencana.presentation.home_screen

import com.example.databencana.domain.model.ReportModel

data class HomeState (
    val reportModel: List<ReportModel> = emptyList(),
    val timePeriod: String? = null,
    val regionCode: String? = null,
    val disaster: String? = null,

    val isLoading: Boolean = false,

    val error: String = ""
)