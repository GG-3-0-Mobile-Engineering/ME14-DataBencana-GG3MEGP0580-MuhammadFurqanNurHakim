package com.example.databencana.presentation.home_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.databencana.presentation.home_screen.components.BottomSheets
import com.example.databencana.presentation.home_screen.components.FilterChips
import com.example.databencana.presentation.home_screen.components.Maps
import com.example.databencana.presentation.home_screen.components.SearchBars

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Log.d("Home Screen", state.reportModel.size.toString())
    Log.d("Home Screen Disaster", state.disaster.toString())

    if (state.isLoading){
        CircularProgressIndicator()
    }else{
        Box (modifier = Modifier.fillMaxSize()){
            Maps(state.reportModel)
            Column {
                SearchBars(navController)
                FilterChips(viewModel)
            }

            BottomSheets(state.reportModel)
        }
    }
}
