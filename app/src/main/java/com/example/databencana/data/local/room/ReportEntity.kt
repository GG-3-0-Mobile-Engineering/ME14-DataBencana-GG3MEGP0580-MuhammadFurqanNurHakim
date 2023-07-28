package com.example.databencana.data.local.room

import androidx.room.Entity

@Entity
data class ReportEntity(
    val lat: Double,
    val lng: Double,

)
