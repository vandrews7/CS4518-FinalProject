package com.example.cs4518_finalproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cs4518_finalproject.Assignment

@Database(entities = [Assignment::class], version = 1)
abstract class AssignmentDatabase : RoomDatabase() {

}