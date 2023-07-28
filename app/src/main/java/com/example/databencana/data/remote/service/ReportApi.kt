package com.example.databencana.data.remote.service

import com.example.databencana.data.remote.response.ReportResponse
import com.example.databencana.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.Response


interface ReportApi {

    @GET(END_POINT)
    suspend fun getReports(): Response<ReportResponse>
}