package com.example.databencana.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.example.databencana.domain.model.ReportModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Maps(
    reportModel: List<ReportModel>
) {

    var camera = LatLng(-5.044679330156558, 115.60813332853861)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(camera, 3.5f)
    }
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0f)
        ,
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings,
    ){
        reportModel.forEach { data ->
            Marker(
                state = MarkerState(position = LatLng(data.coordinates[1], data.coordinates[0])),
                title = data.type,
                snippet = data.date,
                onClick = {
                    camera = LatLng(data.coordinates[1], data.coordinates[0])
                    it.showInfoWindow()
                    true
                }
            )
        }
    }
}