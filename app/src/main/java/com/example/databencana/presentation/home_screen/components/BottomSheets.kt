package com.example.databencana.presentation.home_screen.components

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databencana.R
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.presentation.home_screen.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets(
    reportModel: List<ReportModel>
) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        modifier = Modifier.zIndex(3f),
        scaffoldState = scaffoldState,
        sheetPeekHeight = 75.dp,
        sheetContent = {
            Text(modifier = Modifier
                .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.disaster_info),
                fontSize = 20.sp
            )
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)

            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(reportModel){ data ->
                        Text(text = "Jenis Bencana: " + data.type)
                    }
                }
            }

        }
    ) {
    }
}