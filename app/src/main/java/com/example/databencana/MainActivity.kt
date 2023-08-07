package com.example.databencana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.databencana.data.local.datastore.UserPreferences
import com.example.databencana.presentation.HomeScreen
import com.example.databencana.ui.theme.DataBencanaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//Mohon maaf sebesar-besarnya aplikasi saya masih belum selesai, saya sangat merasa kesulitan untuk menghubungkan APInya

        setContent {

            val context = LocalContext.current

            val dataStore = UserPreferences(context)

            val darkMode = dataStore.getDarkMode.collectAsState(initial = false)

            val navController = rememberNavController()

            DataBencanaTheme(darkTheme = darkMode.value!!){

                NavHost(
                    navController = navController,
                    startDestination = "Main Screen"
                ){
                    composable("Main Screen"){
                        HomeScreen(navController, dataStore, darkMode.value!!)
                    }

                }


            }
        }
    }
}
