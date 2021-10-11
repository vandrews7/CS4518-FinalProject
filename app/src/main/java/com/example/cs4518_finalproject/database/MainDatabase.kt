package com.example.cs4518_finalproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cs4518_finalproject.Assignment
import com.example.cs4518_finalproject.User

@Database(entities = [Assignment::class, User::class], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class MainDatabase : RoomDatabase() {
}