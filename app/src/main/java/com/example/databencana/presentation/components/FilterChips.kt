package com.example.databencana.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.databencana.presentation.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(
    viewModel: HomeViewModel
) {

    val disasterList = viewModel.state.value.disasterType

    Log.d("Disaster type", disasterList.size.toString())

    val selectedItems = remember { mutableStateOf("") }


    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
    ){
        items(disasterList){disaster ->
            ElevatedFilterChip(
                modifier = Modifier.padding(horizontal = 6.dp),
                selected = disaster.code == selectedItems.value,
                shape = FilterChipDefaults.shape,
//                colors = FilterChipDefaults.filterChipColors(
//                    containerColor = Color.White,
//                    selectedContainerColor = Color.Green,
//
//                ),
                onClick = {
                    println(selectedItems)
                    if (disaster.code != selectedItems.value){
                        selectedItems.value = disaster.code
                        viewModel.getDisaster(disaster.code)
                    }else{
                        selectedItems.value = ""
                        viewModel.getDisaster(disaster = null)
                    }
                },
                label = { Text(text = disaster.label)},
                leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
            )
        }
    }
}

