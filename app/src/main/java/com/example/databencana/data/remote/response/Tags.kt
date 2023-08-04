package com.example.databencana.data.remote.response


import com.google.gson.annotations.SerializedName

data class Tags(
    @SerializedName("district_id")
    val districtId: String? = null,
    @SerializedName("instance_region_code")
    val instanceRegionCode: String? = null,
    @SerializedName("local_area_id")
    val localAreaId: String? = null,
    @SerializedName("region_code")
    val regionCode: String? = null
)