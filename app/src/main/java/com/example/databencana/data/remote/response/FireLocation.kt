package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class FireLocation(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lng")
    val lng: Double? = null
)