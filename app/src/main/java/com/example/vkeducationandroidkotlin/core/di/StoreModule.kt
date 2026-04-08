package com.example.vkeducationandroidkotlin.core.di

import com.example.vkeducationandroidkotlin.feature.store.data.AppRepositoryImplMock
import com.example.vkeducationandroidkotlin.feature.store.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface StoreModule {
    @Binds
    fun appRepository(impl: AppRepositoryImplMock): AppRepository
}