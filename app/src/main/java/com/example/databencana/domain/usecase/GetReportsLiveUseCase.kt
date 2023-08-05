package com.example.databencana.domain.usecase

import com.example.databencana.domain.model.DisasterType
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.model.Province
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReportsLiveUseCase @Inject constructor(
    private val reportRepository: ReportsRepository
) {

     fun getReportsLive(timerPeriod: String?, regionCode: String?, disaster: String?): Flow<Resource<List<ReportModel>>>{
        return reportRepository.getReportsLive(timerPeriod, regionCode, disaster)
    }

    fun getDisasterType(): Flow<List<DisasterType>>{
        return reportRepository.getDisasterType()
    }

    fun getSupportedArea(): Flow<List<Province>>{
        return reportRepository.getSupportedArea()
    }
}