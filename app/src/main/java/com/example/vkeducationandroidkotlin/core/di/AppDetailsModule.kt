package com.example.vkeducationandroidkotlin.core.di

import com.example.vkeducationandroidkotlin.feature.appDetails.data.AppDetailsRepositoryImpl
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppDetailsModule {
    @Binds
    fun appDetailsRepository(impl: AppDetailsRepositoryImpl): AppDetailsRepository
}