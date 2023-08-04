package com.example.databencana.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databencana.domain.usecase.GetReportsArchiveUseCase
import com.example.databencana.domain.usecase.GetReportsLiveUseCase
import com.example.databencana.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getReportsLiveUseCase: GetReportsLiveUseCase,
    private val getReportsArchiveUseCase: GetReportsArchiveUseCase,
//    savedStateHandle: SavedStateHandle

):ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getReportLive()
//        getReportArchive("2023-07-20T00%3A00%3A00%2B0700", "2023-07-23T05%3A00%3A00%2B0700")

    }

//    timeperiod: String, regionCode: String, disaster: String
//    timeperiod, regionCode, disaster
     fun getReportLive(){

        val timerPeriod = _state.value.timePeriod
        val regionCode = _state.value.regionCode
        val disaster = _state.value.disaster

        Log.d("getReportLive", disaster.toString())

        viewModelScope.launch {
            getReportsLiveUseCase(timerPeriod, regionCode, disaster).onEach { result ->
                when(result){
                    is Resource.Success -> {
                        Log.d("getReportsLiveUseCase Success", result.data?.size.toString())
                        _state.value = _state.value.copy(
                            reportModel = result.data ?: emptyList(),
                            isLoading = false,
                            disaster = disaster
                        )
                    }
                    is Resource.Error -> {
                        Log.d("getReportsLiveUseCase Error", result.message.toString())
                        _state.value = _state.value.copy(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        Log.d("getReportsLiveUseCase Loading", "Loading")
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(this)
        }
//        val timePeriod = _state.value.timePeriod
//        val regionCode = _state.value.regionCode
//        val disaster = _state.value.disaster




    }

//    private fun getReportArchive(start: String, end: String){
//        getReportsArchiveUseCase(start, end).onEach { result ->
//            when(result){
//                is Resource.Success -> {
//                    _state.value = HomeState(reportModel = result.data ?: emptyList())
//                }
//                is Resource.Error -> {
//                    _state.value = HomeState(
//                        error = result.message ?: "An unexpected error occurred"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = HomeState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
//
//    }

    fun getDisaster(disaster: String?){
        Log.d("Before getDisaster", state.value.disaster.toString())
        _state.value = _state.value.copy(disaster = disaster)
    }

}