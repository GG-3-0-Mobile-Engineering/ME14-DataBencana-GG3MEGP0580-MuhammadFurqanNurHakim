package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName

data class Result(
    val type: String = "",
    val features: List<DataReport> = emptyList(),
)