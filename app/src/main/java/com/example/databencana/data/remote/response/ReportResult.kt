package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class ReportResult(
    @SerializedName("result")
    val result: Result? = null,
    @SerializedName("statusCode")
    val statusCode: Int? = null
)