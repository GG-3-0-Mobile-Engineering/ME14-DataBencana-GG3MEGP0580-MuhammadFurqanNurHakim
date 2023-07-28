package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Feature(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("geometry")
    val geometry: Geometry = Geometry(),
    @SerializedName("properties")
    val properties: Properties = Properties(),
)