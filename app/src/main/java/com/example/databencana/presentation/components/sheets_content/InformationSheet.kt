package com.example.databencana.presentation.components.sheets_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.databencana.R
import com.example.databencana.domain.model.ReportModel

@Composable
fun InformationSheet(
    reportModel: List<ReportModel>
) {

    if (reportModel.isNotEmpty()){
        LazyColumn{
            items(reportModel){ report ->
                ListItem(
                    headlineContent = { Text(text = report.title) },
                    supportingContent = { Text(text = report.text)},
//        leadingContent = { Text(text = "Leading Content")},
                    trailingContent = { Text(text = report.type)}
                )
                Divider()
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
    }else{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.empty_data))
        }
        Spacer(modifier = Modifier.height(80.dp))
    }



}