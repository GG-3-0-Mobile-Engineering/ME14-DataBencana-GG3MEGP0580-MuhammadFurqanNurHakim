package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName

data class ReportData(
    val accessabilityFailure: Int = 0,
    val airQuality: Int = 0,
    val condition: Int = 0,
    val evacuationArea: Boolean = false,
    val evacuationNumber: Int = 0,
    val fireDistance: Double= 0.0,
    val fireLocation: FireLocation = FireLocation(),
    val fireRadius: FireRadius = FireRadius(),
    val floodDepth: Int= 0,
    val impact: Int = 0,
    val personLocation: PersonLocation = PersonLocation(),
    val reportType: String = "",
    val structureFailure: Int = 0,
    val visibility: Int = 0,
    val volcanicSigns: List<Int> = emptyList()
)