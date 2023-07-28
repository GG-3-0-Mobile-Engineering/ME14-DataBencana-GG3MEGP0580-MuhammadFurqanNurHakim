package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class FireRadius(
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lng")
    val lng: Double = 0.0
)