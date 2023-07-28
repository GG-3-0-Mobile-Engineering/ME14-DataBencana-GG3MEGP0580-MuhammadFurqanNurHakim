package com.example.databencana.data.remote.service

import com.example.databencana.data.remote.response.Feature
import com.example.databencana.data.remote.response.ReportResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReportService @Inject constructor(private val reportApi: ReportApi) {

    suspend fun getReport(): ReportResponse{
        return withContext(Dispatchers.IO){
            val response = reportApi.getReports()
            response.body() ?: ReportResponse()
        }
    }

}