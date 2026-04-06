package com.example.vkeducationandroidkotlin.feature.appDetails.data.local

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json

class ScreenshotUrlListConverter {
    private val json = Json

    @TypeConverter
    fun fromScreenshotUrlList(screenshotUrlList: List<String>): String {
        return json.encodeToString(screenshotUrlList)
    }

    @TypeConverter
    fun toScreenshotUrlList(screenshotUrlList: String): List<String> {
        return json.decodeFromString(screenshotUrlList)
    }
}
