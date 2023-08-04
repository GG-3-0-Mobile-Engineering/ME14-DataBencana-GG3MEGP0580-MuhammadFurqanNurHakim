package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class ReportData(
    @SerializedName("accessabilityFailure")
    val accessabilityFailure: Int? = null,
    @SerializedName("airQuality")
    val airQuality: Int? = null,
    @SerializedName("condition")
    val condition: Int? = null,
    @SerializedName("evacuationArea")
    val evacuationArea: Boolean? = null,
    @SerializedName("evacuationNumber")
    val evacuationNumber: Int? = null,
    @SerializedName("fireDistance")
    val fireDistance: Double? = null,
    @SerializedName("fireLocation")
    val fireLocation: FireLocation? = null,
    @SerializedName("fireRadius")
    val fireRadius: FireRadius? = null,
    @SerializedName("flood_depth")
    val floodDepth: Int? = null,
    @SerializedName("impact")
    val impact: Int? = null,
    @SerializedName("personLocation")
    val personLocation: PersonLocation? = null,
    @SerializedName("report_type")
    val reportType: String? = null,
    @SerializedName("structureFailure")
    val structureFailure: Int? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("volcanicSigns")
    val volcanicSigns: List<Int>? = null
)