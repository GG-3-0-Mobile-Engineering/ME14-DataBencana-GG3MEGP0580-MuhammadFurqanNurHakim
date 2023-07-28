package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("statusCode")
    val statusCode: Int = 0,
    @SerializedName("result")
    val result: Result = Result(),
)