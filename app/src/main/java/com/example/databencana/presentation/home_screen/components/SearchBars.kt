package com.example.databencana.presentation.home_screen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.databencana.R
import com.example.databencana.presentation.home_screen.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBars(
    navController: NavController,
    viewModel: HomeViewModel
    ) {

    val province = viewModel.state.value.province
    val searchText by viewModel.searchText.collectAsState()
    val searchProvince by viewModel.searchProvince(province).collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    DockedSearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 16.dp),
        query = searchText,
        onQueryChange = viewModel::onSearchTextChange ,
        onSearch = {
                    viewModel.isSearching(false)
                    active = false
                    viewModel.getRegionCode(searchProvince[0].code, searchProvince[0].name )
                   },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text(text = stringResource(id = R.string.search))},
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search") },
        trailingIcon = {
            if (!active){
                Row {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.DateRange,
                            contentDescription = "Date Range",
                        )
                    }
                    IconButton(onClick = {navController.navigate("Settings")}) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                        )
                    }
                }
            } else{
                IconButton(onClick = {
                    if (searchText != "") {
                        viewModel.getRegionCode(null, "")
                    } else {
                        active = false
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear")
                }
            }
        }
    ) {
        if(isSearching){
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }else{
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                Log.d("Search Province: ", searchProvince.size.toString())
                items(searchProvince){ province ->
                    Text(
                        text = province.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp)
                            .padding(horizontal = 12.dp)
                            .clickable {
                                active = false
                                viewModel.getRegionCode(province.code, province.name)
                            }
                    )
                    Divider()
                }
            }
        }
    }
}