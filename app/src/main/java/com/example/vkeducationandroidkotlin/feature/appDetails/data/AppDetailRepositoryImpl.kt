package com.example.vkeducationandroidkotlin.feature.appDetails.data

import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetail
import com.example.vkeducationandroidkotlin.feature.appDetails.domain.AppDetailRepository

class AppDetailRepositoryImpl : AppDetailRepository {
    override suspend fun get(id: String): AppDetail {
        TODO("В будущем сделать тут работу с backend")
    }
}