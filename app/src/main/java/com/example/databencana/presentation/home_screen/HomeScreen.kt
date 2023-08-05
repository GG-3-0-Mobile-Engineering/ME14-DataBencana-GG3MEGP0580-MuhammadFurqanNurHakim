package com.example.databencana.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
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

    if (viewModel.state.value.isLoading){
        CircularProgressIndicator()
    }else{
        Box (modifier = Modifier.fillMaxSize()){
            Maps(viewModel.state.value.reportModel)
            Column {
                SearchBars(navController, viewModel)
                FilterChips(viewModel)
            }

            BottomSheets(viewModel.state.value.reportModel)
        }
    }
}
