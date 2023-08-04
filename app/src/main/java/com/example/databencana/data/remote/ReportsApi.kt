package com.example.databencana.data.remote

import com.example.databencana.data.remote.response.ReportResult
import retrofit2.http.GET
import retrofit2.http.Query


interface ReportsApi {

    @GET("reports")
    suspend fun getLiveReport(
        @Query("timeperiod") timePeriod: String?,
        @Query("admin") regionCode: String?,
        @Query("disaster") disaster: String?
    ): ReportResult

    //belum bisa filter disaster
    @GET("reports/archive")
    suspend fun getArchiveReport(
        @Query("start") start: String,
        @Query("end") end: String,
    ): ReportResult


}