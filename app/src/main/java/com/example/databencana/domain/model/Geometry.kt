package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName

data class Geometry(
    val type: String = "",
    val coordinates: List<Double> = emptyList(),
)