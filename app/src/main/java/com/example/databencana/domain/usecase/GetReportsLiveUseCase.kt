package com.example.databencana.domain.usecase

import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetReportsLiveUseCase @Inject constructor(
    private val reportRepository: ReportsRepository
) {

    operator fun invoke(timerPeriod: String?, regionCode: String?, disaster: String?): Flow<Resource<List<ReportModel>>>{
        return reportRepository.getReportsLive(timerPeriod, regionCode, disaster)
    }

}