package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Properties(
    val pkey: String = "",
    val createdAt: Timestamp? = null,
    val disasterType: String = "",
    val imageUrl: String = "",
    val partnerCode: String = "",
    val partnerIcon: String = "",
    val reportData: ReportData = ReportData(),
    val source: String = "",
    val status: String = "",
    val tags: Tags = Tags(),
    val text: String = "",
    val title: String = "",
    val url: String = ""
)