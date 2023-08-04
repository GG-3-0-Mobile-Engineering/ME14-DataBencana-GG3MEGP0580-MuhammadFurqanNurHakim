package com.example.databencana.data.remote.response


import com.example.databencana.domain.model.ReportModel
import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("coordinates")
    val coordinates: List<Double>? = null,
    @SerializedName("properties")
    val properties: Properties? = null,
    @SerializedName("type")
    val type: String? = null
)

fun Geometry.toReportModel(): ReportModel {
    return ReportModel(
        type = properties?.disasterType ?: "",
        date = properties?.createdAt ?: "",
        source = properties?.source ?: "",
        status = properties?.status ?: "",
        url = properties?.url ?: "",
        img = properties?.imageUrl ?: "",
        report = properties?.reportData ?: ReportData(),
        title = properties?.title ?: "",
        text = properties?.text ?: "",
        coordinates = coordinates ?: emptyList()
    )
}