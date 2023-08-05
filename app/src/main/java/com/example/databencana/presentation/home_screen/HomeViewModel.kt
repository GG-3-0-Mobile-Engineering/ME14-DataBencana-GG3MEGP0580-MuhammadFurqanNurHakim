package com.example.databencana.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databencana.domain.model.Province
import com.example.databencana.domain.usecase.GetReportsLiveUseCase
import com.example.databencana.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getReportsLiveUseCase: GetReportsLiveUseCase,
//    private val getReportsArchiveUseCase: GetReportsArchiveUseCase,
):ViewModel() {



    //Home State
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    //Search Attribute
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    init {
        viewModelScope.launch {
            getDisasterType()
            getSupportedArea()
            delay(1000L)
            getReportLive()
        }
    }

    //Report Disaster Function
    fun getReportLive(){

        val timerPeriod = _state.value.timePeriod
        val regionCode = _state.value.regionCode
        val disaster = _state.value.disaster

        Log.d("getReportLive", disaster.toString())

        viewModelScope.launch {
            getReportsLiveUseCase.getReportsLive(timerPeriod, regionCode, disaster).onEach { result ->
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

    }

    private fun getDisasterType(){
        viewModelScope.launch {
            getReportsLiveUseCase.getDisasterType().collect {
                _state.value = _state.value.copy(disasterType = it)
            }
        }
    }

    private fun getSupportedArea(){
        viewModelScope.launch {
            getReportsLiveUseCase.getSupportedArea().collect {
                _state.value = _state.value.copy(province = it)
            }
        }
    }

    fun getDisaster(disaster: String?){
        _state.value = _state.value.copy(disaster = disaster)
        getReportLive()
    }
    fun getRegionCode(regionCode: String?, text: String){
        _state.value = _state.value.copy(regionCode = regionCode)
        _searchText.value = text
        getReportLive()
    }


    //Searching Function
    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun isSearching(bool: Boolean){
        _isSearching.value = bool
    }

    fun searchProvince(provinceList: List<Province>): StateFlow<List<Province>> {
        val province = MutableStateFlow(provinceList)
        val result = searchText
            .debounce(1000L)
            .onEach { _isSearching.update { true } }
            .combine(province){text, data ->
                if (text.isBlank()){
                    data
                }else{
                    delay(2000L)
                    data.filter { it.name.contains(text, ignoreCase = true) }
                }
            }.onEach { _isSearching.update { false } }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                province.value
            )
        return result
    }

}