package com.example.databencana.presentation.components.sheets_content

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.databencana.data.local.datastore.UserPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SettingSheet(
    scope: CoroutineScope,
    dataStore: UserPreferences,
    darkMode: Boolean
) {
    var isChecked by remember { mutableStateOf(darkMode) }

    ListItem(
        headlineContent = { Text(text = "Dark Mode") },
        supportingContent = { Text(text = "Switch between light and dark mode")},
        trailingContent = {
            Switch(
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 80.dp),
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    scope.launch { dataStore.saveDarkMode(isChecked) }
                },
            )
        }
    )
    Spacer(modifier = Modifier.height(80.dp))
}