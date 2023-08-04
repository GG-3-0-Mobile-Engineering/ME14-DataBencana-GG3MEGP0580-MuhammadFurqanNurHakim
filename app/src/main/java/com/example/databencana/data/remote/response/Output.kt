package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Output(
    @SerializedName("geometries")
    val geometries: List<Geometry>? = null,
    @SerializedName("type")
    val type: String? = null
)