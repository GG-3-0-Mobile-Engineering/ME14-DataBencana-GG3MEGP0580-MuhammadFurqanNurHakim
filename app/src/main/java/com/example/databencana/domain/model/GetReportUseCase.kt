package com.example.databencana.domain.model

import com.example.databencana.data.repository.ReportRepo
import javax.inject.Inject

class GetReportUseCase @Inject constructor(private val reportRepo: ReportRepo){

    suspend operator fun invoke(): List<DataReport>{
        return reportRepo.getReport()
    }

}