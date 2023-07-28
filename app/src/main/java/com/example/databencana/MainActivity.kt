package com.example.databencana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.databencana.presentation.map.MapScreen
import com.example.databencana.ui.theme.DataBencanaTheme
import com.example.databencana.data.local.datastore.UserPreferences
import com.example.databencana.presentation.BottomSheets
import com.example.databencana.presentation.FilterChips
import com.example.databencana.presentation.SearchBars
import com.example.databencana.presentation.SettingScreen
import com.example.databencana.presentation.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//Mohon maaf sebesar-besarnya aplikasi saya masih belum selesai, saya sangat merasa kesulitan untuk menghubungkan APInya

        setContent {

            val context = LocalContext.current

            val scope = rememberCoroutineScope()

            val dataStore = UserPreferences(context)

            val darkMode = dataStore.getDarkMode.collectAsState(initial = false)

            DataBencanaTheme(darkTheme = darkMode.value!!){
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Main Screen"
                ){
                    composable("Main Screen"){
                        HomeScreen(darkMode.value!!, navController)
                    }
                    composable("Settings"){
                        SettingScreen(navController, scope, dataStore, darkMode.value!!)
                    }
                }


            }
        }
    }
}
