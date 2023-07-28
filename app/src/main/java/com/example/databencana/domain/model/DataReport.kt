package com.example.databencana.domain.model

import com.example.databencana.data.remote.response.Feature


data class DataReport(
    val type: String,
    val geometry: Geometry,
    val properties: Properties,
)

fun Feature.toDataReport() = DataReport(type, Geometry(), Properties())