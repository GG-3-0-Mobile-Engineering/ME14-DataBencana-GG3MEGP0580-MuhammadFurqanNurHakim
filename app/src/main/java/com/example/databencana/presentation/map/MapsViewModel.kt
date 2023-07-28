package com.example.databencana.presentation.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapsViewModel: ViewModel() {

    var state by mutableStateOf(MapState())

    fun onEvent(event: MapEvent){
        when(event){
            is MapEvent.ToogleDarkMode -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if (state.isDarkMode){
                            null
                        } else MapStyleOptions(MapStyle.json),
                    ),
                    isDarkMode = !state.isDarkMode
                )
            }
        }
    }

}