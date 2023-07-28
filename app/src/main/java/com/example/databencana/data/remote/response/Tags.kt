package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Tags(
    @SerializedName("district_id")
    val districtId: Int = 0,
    @SerializedName("instance_region_code")
    val instanceRegionCode: String = "",
    @SerializedName("local_area_id")
    val localAreaId: Int = 0,
    @SerializedName("region_code")
    val regionCode: Int = 0
)