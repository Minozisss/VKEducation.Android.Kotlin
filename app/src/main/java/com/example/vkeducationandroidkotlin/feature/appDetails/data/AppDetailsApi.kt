package com.example.vkeducationandroidkotlin.feature.appDetails.data

import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsApi {
    @GET("/catalog/{id}")
    suspend fun get(@Path("id") id: String): AppDetailsDto
}