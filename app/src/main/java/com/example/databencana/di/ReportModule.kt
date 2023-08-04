package com.example.databencana.di

import com.example.databencana.data.remote.ReportsApi
import com.example.databencana.data.repository.ReportsRepositoryImpl
import com.example.databencana.domain.repository.ReportsRepository
import com.example.databencana.domain.usecase.GetReportsLiveUseCase
import com.example.databencana.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReportModule {

    @Provides
    @Singleton
    fun provideGetReportsLiveUseCase(reportsRepository: ReportsRepository): GetReportsLiveUseCase{
        return GetReportsLiveUseCase(reportsRepository)
    }

    @Provides
    @Singleton
    fun provideReportsApi(): ReportsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReportsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideReportsRepository(api: ReportsApi): ReportsRepository {
        return ReportsRepositoryImpl(api)
    }

}