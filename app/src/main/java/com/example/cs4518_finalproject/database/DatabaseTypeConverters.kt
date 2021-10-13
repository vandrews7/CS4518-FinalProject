package com.example.cs4518_finalproject.database

import androidx.room.TypeConverter
import java.util.*

class DatabaseTypeConverters {

    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}