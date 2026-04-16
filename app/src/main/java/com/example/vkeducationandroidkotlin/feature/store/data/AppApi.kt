package com.example.vkeducationandroidkotlin.feature.store.data

import retrofit2.http.GET

interface AppApi {
    @GET("/catalog")
    suspend fun get(): List<AppDto>
}