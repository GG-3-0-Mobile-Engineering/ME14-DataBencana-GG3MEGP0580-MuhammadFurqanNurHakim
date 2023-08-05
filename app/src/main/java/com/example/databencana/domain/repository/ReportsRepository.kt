package com.example.databencana.domain.repository

import com.example.databencana.domain.model.DisasterType
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.model.Province
import com.example.databencana.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ReportsRepository {

//    suspend fun getReportsLive(): ReportResult

     fun getReportsLive(timerPeriod: String?, regionCode: String?, disaster: String?): Flow<Resource<List<ReportModel>>>

     fun getDisasterType(): Flow<List<DisasterType>>

     fun getSupportedArea(): Flow<List<Province>>

//    suspend fun getReportsLive(timerPeriod: String?, regionCode: String?, disaster: String?): ReportResult
//
//    suspend fun getReportsArchive(start: String, end: String): ReportResult

}