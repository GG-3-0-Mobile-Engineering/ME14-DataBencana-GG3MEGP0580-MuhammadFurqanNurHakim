package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("disaster_type")
    val disasterType: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("partner_code")
    val partnerCode: String? = null,
    @SerializedName("partner_icon")
    val partnerIcon: String? = null,
    @SerializedName("pkey")
    val pkey: String? = null,
    @SerializedName("report_data")
    val reportData: ReportData? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("tags")
    val tags: Tags? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
)