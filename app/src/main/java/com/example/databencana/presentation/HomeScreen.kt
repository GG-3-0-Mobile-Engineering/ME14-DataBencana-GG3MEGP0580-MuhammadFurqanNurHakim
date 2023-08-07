package com.example.databencana.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.databencana.R
import com.example.databencana.data.local.datastore.UserPreferences
import com.example.databencana.presentation.components.BottomSheets
import com.example.databencana.presentation.components.FilterChips
import com.example.databencana.presentation.components.Maps
import com.example.databencana.presentation.components.SearchBars
import com.example.databencana.presentation.components.sheets_content.InformationSheet
import com.example.databencana.presentation.components.sheets_content.SettingSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    dataStore: UserPreferences,
    darkMode: Boolean,
    viewModel: HomeViewModel = hiltViewModel()
) {

    //Navigation Section
    var selectedItem by remember { mutableStateOf("") }

    val navigation = listOf(
        stringResource(id = R.string.nav_notif),
        stringResource(id = R.string.nav_info),
        stringResource(id = R.string.nav_setting))

    val sheetState = androidx.compose.material.rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = false)

    val scope = rememberCoroutineScope()

    //Report Model
    val reportModel = viewModel.state.value.reportModel


    //Screen
    if (viewModel.state.value.isLoading){
        CircularProgressIndicator()
    }else{
        Scaffold (
            bottomBar = {
                NavigationBar {
                     navigation.forEach { item ->
                         NavigationBarItem(
                             selected = selectedItem == item,
                             onClick = {
                                 if (selectedItem != item){
                                     selectedItem = item
                                     scope.launch {
                                         sheetState.hide()
                                         sheetState.show()
                                     }
                                 }else{
                                     selectedItem = ""
                                     scope.launch { sheetState.hide() }
                                 }
                            },
                             icon = {
                                 when(item){
                                     navigation[0] -> Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notification")
                                     navigation[1] -> Icon(imageVector = Icons.Filled.Home, contentDescription = "Information")
                                     navigation[2] -> Icon(imageVector = Icons.Filled.Settings, contentDescription = "Setting")
                                 }
                             },
                             label = { Text(text = item)}
                         )
                     }
                }
            }
        ){
            Box (modifier = Modifier
                .fillMaxSize()
                .padding(it)
            ) {
                Maps(reportModel)
                Column {
                    SearchBars(viewModel)
                    FilterChips(viewModel)
                }
            }
            BottomSheets(sheetState) {
//                Text(text = "Title")
//                Spacer(modifier = Modifier.height(24.dp))
//                Text(text = selectedItem)
//                Divider(modifier = Modifier.padding(vertical = 5.dp))

                androidx.compose.material3.Surface {
                    Column {
                        Spacer(modifier = Modifier.height(18.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = selectedItem)
                        }
                        Divider(modifier = Modifier.padding(vertical = 5.dp))
                        when(selectedItem){
                            navigation[0] -> {}
                            navigation[1] -> {
                                InformationSheet(reportModel = reportModel)
                            }
                            navigation[2] -> {
                                SettingSheet(scope = scope, dataStore = dataStore, darkMode = darkMode)
                            }
                        }
                    }
                }


            }

        }


    }
}
