package com.example.databencana.data.repository

import com.example.databencana.data.remote.ReportsApi
import com.example.databencana.data.remote.response.toReportModel
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ReportsRepositoryImpl @Inject constructor(
    private val api: ReportsApi
): ReportsRepository {

    override fun getReportsLive(
        timerPeriod: String?,
        regionCode: String?,
        disaster: String?
    ): Flow<Resource<List<ReportModel>>> = flow {
        try {
//            emit(Resource.Loading())
            val data = api.getLiveReport(timerPeriod, regionCode, disaster).result?.objects?.output?.geometries?.map { it.toReportModel() }
            emit(Resource.Success(data ?: emptyList()))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    //    override suspend fun getReportsLive(timerPeriod: String?, regionCode: String?, disaster: String?): Flow<Response<List<ReportModel>>> {
//        return api.getLiveReport(timerPeriod, regionCode, disaster)
//    }

//    override suspend fun getReportsLive(timeperiod: String, regionCode: String, disaster: String): ReportResult {
//        return api.getLiveReport(timeperiod, regionCode, disaster)
//    }

//    override suspend fun getReportsArchive(start: String, end: String): ReportResult {
//        return api.getArchiveReport(start, end)
//    }
}