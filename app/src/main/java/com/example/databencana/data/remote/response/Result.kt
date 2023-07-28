package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("features")
    val features: List<Feature> = emptyList(),
)