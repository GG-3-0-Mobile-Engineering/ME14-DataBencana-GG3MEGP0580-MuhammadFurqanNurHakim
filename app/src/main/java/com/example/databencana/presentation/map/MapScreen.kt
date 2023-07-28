package com.example.databencana.presentation.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    darkMode: Boolean,
    viewModel: MapsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val indonesia = LatLng(-5.044679330156558, 115.60813332853861)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(indonesia, 3.5f)
    }
    val nums = arrayOf(1, 5, 10, 15, 20)
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }

//    if (darkMode){
//        viewModel.onEvent(MapEvent.ToogleDarkMode)
//    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = viewModel.state.properties,
        uiSettings = uiSettings,
    ){

    }
}