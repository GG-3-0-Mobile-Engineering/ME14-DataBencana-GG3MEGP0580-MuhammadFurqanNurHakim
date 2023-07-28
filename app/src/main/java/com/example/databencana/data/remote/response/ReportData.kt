package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class ReportData(
    @SerializedName("accessabilityFailure")
    val accessabilityFailure: Int = 0,
    @SerializedName("airQuality")
    val airQuality: Int = 0,
    @SerializedName("condition")
    val condition: Int = 0,
    @SerializedName("evacuationArea")
    val evacuationArea: Boolean = false,
    @SerializedName("evacuationNumber")
    val evacuationNumber: Int = 0,
    @SerializedName("fireDistance")
    val fireDistance: Double= 0.0,
    @SerializedName("fireLocation")
    val fireLocation: FireLocation = FireLocation(),
    @SerializedName("fireRadius")
    val fireRadius: FireRadius = FireRadius(),
    @SerializedName("flood_depth")
    val floodDepth: Int= 0,
    @SerializedName("impact")
    val impact: Int = 0,
    @SerializedName("personLocation")
    val personLocation: PersonLocation = PersonLocation(),
    @SerializedName("report_type")
    val reportType: String = "",
    @SerializedName("structureFailure")
    val structureFailure: Int = 0,
    @SerializedName("visibility")
    val visibility: Int = 0,
    @SerializedName("volcanicSigns")
    val volcanicSigns: List<Int> = emptyList()
)