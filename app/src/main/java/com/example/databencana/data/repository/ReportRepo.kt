package com.example.databencana.data.repository

import com.example.databencana.data.remote.response.Feature
import com.example.databencana.data.remote.service.ReportService
import com.example.databencana.domain.model.DataReport
import com.example.databencana.domain.model.toDataReport
import javax.inject.Inject

class ReportRepo @Inject constructor(
    private val reportService: ReportService
) {

    suspend fun getReport(): List<DataReport> {
        val report = reportService.getReport()
        return report.result.features.map {
            it.toDataReport()
        }
    }

}