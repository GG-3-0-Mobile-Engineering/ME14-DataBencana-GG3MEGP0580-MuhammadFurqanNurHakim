package com.example.databencana.domain.usecase

import com.example.databencana.domain.model.ReportModel
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetReportsArchiveUseCase @Inject constructor(
    private val reportRepository: ReportsRepository
) {

//    operator fun invoke(start: String, end: String): Flow<Resource<List<ReportModel>>> = flow {
//        try {
//            emit(Resource.Loading<List<ReportModel>>())
//            val data = reportRepository.getReportsArchive(start, end).result?.objects?.output?.geometries?.map { it.toReport() }
//            emit(Resource.Success<List<ReportModel>>(data ?: emptyList()))
//        } catch (e: HttpException){
//            emit(Resource.Error<List<ReportModel>>(e.localizedMessage ?: "An unexpected error occured"))
//        } catch (e: IOException){
//            emit(Resource.Error<List<ReportModel>>("Couldn't reach server. Check your internet connection."))
//        }
//    }

}