package com.example.databencana.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databencana.data.remote.response.ReportResponse
import com.example.databencana.domain.model.DataReport
import com.example.databencana.presentation.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets() {

//    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
//    val report by homeViewModel.report.collectAsState()

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 75.dp,
        sheetContent = {
            Text(modifier = Modifier
                .align(Alignment.CenterHorizontally),
                text = "Informasi Bencana Terikini",
                fontSize = 20.sp
            )
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)

            ) {

            }
//            LazyColumn{
//                items(report){ data: DataReport ->
//                    Text(text = data.type)
//                }
//            }
        }
    ) {
    }
}