package com.example.databencana.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences (private val context: Context) {

    //to make sure there is only one instance
    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DarkMode")
        val DarkMode = booleanPreferencesKey("dark_mode")
    }

    //to get the dark mode preferences
    val getDarkMode: Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[DarkMode] ?: false
        }

    //to save dark mode preferences
    suspend fun saveDarkMode(darkMode: Boolean){
        context.dataStore.edit { preferences ->
            preferences[DarkMode] = darkMode
        }
    }
}