package com.example.databencana.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.databencana.presentation.BottomSheets
import com.example.databencana.presentation.FilterChips
import com.example.databencana.presentation.SearchBars
import com.example.databencana.presentation.map.MapScreen

@Composable
fun HomeScreen(
    darkMode: Boolean,
    navController: NavController
) {

//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val report by homeViewModel.report.collectAsState()
//    println("SIZE REPORT " + report.size)

//    if (report.isEmpty()){
//        CircularProgressIndicator(
//            modifier = Modifier.fillMaxSize()
//                .wrapContentSize(align = Alignment.Center)
//        )
//    }

    Box {
        MapScreen(darkMode)
        Column {
            SearchBars(navController)
            FilterChips()
            BottomSheets()
        }
    }
}