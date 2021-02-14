package com.example.numberlistview.data

import androidx.room.TypeConverter
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class ListToJSONConverter {
    @TypeConverter
    fun listToJson(list: List<Int>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun jsonToList(string: String): List<Int> {
        return Json.decodeFromString(string)
    }
}