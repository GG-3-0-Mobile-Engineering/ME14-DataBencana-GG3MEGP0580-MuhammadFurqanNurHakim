package com.example.databencana.presentation.map

import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isDarkMode: Boolean = false
)
