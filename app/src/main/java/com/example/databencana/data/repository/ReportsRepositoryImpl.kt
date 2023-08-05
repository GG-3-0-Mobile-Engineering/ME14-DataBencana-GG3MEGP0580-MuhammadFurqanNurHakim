package com.example.databencana.data.repository

import android.content.Context
import com.example.databencana.R
import com.example.databencana.data.remote.ReportsApi
import com.example.databencana.data.remote.response.toReportModel
import com.example.databencana.domain.model.DisasterType
import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.model.Province
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ReportsRepositoryImpl @Inject constructor(
    private val api: ReportsApi,
    @ApplicationContext private val context: Context
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

    override fun getDisasterType(): Flow<List<DisasterType>> = flow {
        val disasterNames = context.resources.getStringArray(R.array.disaster_names)
        val disasterCodes = context.resources.getStringArray(R.array.disaster_codes)
        val disasterType = disasterNames.mapIndexed { index, _ ->
            DisasterType(
                label = disasterNames[index],
                code = disasterCodes[index]
            )
        }
        emit(disasterType)
    }

    override fun getSupportedArea(): Flow<List<Province>> = flow {
        val provinceNames = context.resources.getStringArray(R.array.province_names)
        val provinceCodes = context.resources.getStringArray(R.array.province_codes)
        val province = provinceNames.mapIndexed { index, _ ->
            Province(
                name = provinceNames[index],
                code = provinceCodes[index]
            )
        }
        emit(province)
    }
}