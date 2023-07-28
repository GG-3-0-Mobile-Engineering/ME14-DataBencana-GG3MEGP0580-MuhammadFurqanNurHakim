package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName

data class ReportResponse(
    val statusCode: Int = 0,
    val result: Result = Result(),
)