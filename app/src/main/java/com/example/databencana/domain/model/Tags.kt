package com.example.databencana.domain.model


import com.google.gson.annotations.SerializedName

data class Tags(
    val districtId: Int = 0,
    val instanceRegionCode: String = "",
    val localAreaId: Int = 0,
    val regionCode: Int = 0
)