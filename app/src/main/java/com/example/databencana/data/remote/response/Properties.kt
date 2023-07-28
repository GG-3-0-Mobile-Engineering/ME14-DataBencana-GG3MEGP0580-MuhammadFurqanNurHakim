package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Properties(
    @SerializedName("pkey")
    val pkey: String = "",
    @SerializedName("created_at")
    val createdAt: Timestamp? = null,
    @SerializedName("disaster_type")
    val disasterType: String = "",
    @SerializedName("image_url")
    val imageUrl: String = "",
    @SerializedName("partner_code")
    val partnerCode: String = "",
    @SerializedName("partner_icon")
    val partnerIcon: String = "",
    @SerializedName("report_data")
    val reportData: ReportData = ReportData(),
    @SerializedName("source")
    val source: String = "",
    @SerializedName("status")
    val status: String = "",
    @SerializedName("tags")
    val tags: Tags = Tags(),
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
)