package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("arcs")
    val arcs: List<Double>? = null,
    @SerializedName("bbox")
    val bbox: List<Double>? = null,
    @SerializedName("objects")
    val objects: Objects? = null,
    @SerializedName("type")
    val type: String? = null
)