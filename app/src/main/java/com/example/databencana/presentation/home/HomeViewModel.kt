package com.example.databencana.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databencana.data.remote.response.ReportResponse
import com.example.databencana.data.remote.service.ApiResponse
import com.example.databencana.data.repository.ReportRepo
import com.example.databencana.domain.model.DataReport
import com.example.databencana.domain.model.GetReportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getReportUseCase: GetReportUseCase
):ViewModel() {

    private  val _report = MutableStateFlow(emptyList<DataReport>())
    val report: StateFlow<List<DataReport>> get() = _report

    init {
        getReport()
    }

    private fun getReport(){

        viewModelScope.launch {

            try {

                val report = getReportUseCase()
                _report.value = report

            }catch (_: Exception) {}

        }

    }

}