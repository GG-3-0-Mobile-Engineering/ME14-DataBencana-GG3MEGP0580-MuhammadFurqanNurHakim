package com.example.databencana.presentation.home_screen

import com.example.databencana.domain.model.DisasterType
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.model.Province

data class HomeState (

    //Disaster Report
    val reportModel: List<ReportModel> = emptyList(),
    val timePeriod: String? = "86400",
    val regionCode: String? = null,
    val disaster: String? = null,

    //Disaster Type
    val disasterType: List<DisasterType> = emptyList(),

    //Supported Area
    val province: List<Province> = emptyList(),

    //Resource
    val isLoading: Boolean = false,
    val error: String = ""

)
