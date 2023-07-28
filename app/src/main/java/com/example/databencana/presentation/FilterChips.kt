package com.example.databencana.presentation

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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips() {
    val disasterList = listOf("Flood", "Earthquake", "Wildfire", "Volcano", "Haze", "Strong Winds")
    val selectedItems = remember { mutableStateListOf<String>() }


    LazyRow(modifier = Modifier.fillMaxWidth()){
        items(disasterList){item ->
            ElevatedFilterChip(
                modifier = Modifier.padding(horizontal = 6.dp),
                selected = selectedItems.contains(item),
                shape = FilterChipDefaults.shape,
//                colors = FilterChipDefaults.filterChipColors(
//                    containerColor = Color.White,
//                    selectedContainerColor = Color.Green,
//
//                ),
                onClick = {
                          if (selectedItems.contains(item)){
                              selectedItems.remove(item)
                          }else{
                              selectedItems.add(item)
                          }
                },
                label = { Text(text = item)},
                leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) }
            )
        }
    }
}